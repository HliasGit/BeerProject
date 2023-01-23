package com.pintbid.project.backend.api;

import com.pintbid.project.backend.models.Role;
import com.pintbid.project.backend.payload.request.LoginRequest;
import com.pintbid.project.backend.payload.request.SignupRequest;
import com.pintbid.project.backend.payload.response.UserInfoResponse;
import com.pintbid.project.backend.repository.RoleRepository;
import com.pintbid.project.backend.repository.UserRepository;
import com.pintbid.project.backend.security.JwtUtils;
import com.pintbid.project.backend.security.services.UserDetailsImpl;
import com.pintbid.project.backend.utils.ERole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.Cookie;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class AuthControllerTest {

    ResponseCookie cookie = ResponseCookie.from("cookieName", "cookieValue")
        .maxAge(Duration.ofDays(1))
        .path("/")
        .secure(true)
        .build();

    LoginRequest loginRequest = new LoginRequest();
    Authentication authentication = Mockito.mock(Authentication.class);
    SignupRequest signUpRequest = new SignupRequest();

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder encoder;

    @Mock
    private JwtUtils jwtUtils;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    void setup(){
        signUpRequest.setFirstname("FirstName");
        signUpRequest.setLastname("LastName");
        signUpRequest.setUsername("UserName");
        signUpRequest.setEmail("email");
        signUpRequest.setPassword("password");
        loginRequest.setPassword("password");
        signUpRequest.getFirstname();
        signUpRequest.getLastname();
        signUpRequest.getUsername();
        signUpRequest.getEmail();
        signUpRequest.getPassword();
        when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()))).thenReturn(authentication);
        when(jwtUtils.getCleanJwtCookie()).thenReturn(cookie);
        when(userRepository.existsByUsername(any())).thenReturn(true);
        when(userRepository.existsByEmail(any())).thenReturn(true);
        when(encoder.encode(any())).thenReturn("password");

    }

    @Test
    void testAuthenticateUser() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));

        UserDetailsImpl userDetails = new UserDetailsImpl(1, "John", "testUser", "Doe", "testuser@test.com", "password", list);

        when(authentication.getPrincipal()).thenReturn(userDetails);

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);

        ResponseCookie jwtCookie = ResponseCookie.from("token", "JWT_TOKEN").build();
        when(jwtUtils.generateJwtCookie(userDetails)).thenReturn(jwtCookie);

        ResponseEntity<?> response = authController.authenticateUser(loginRequest);

        UserInfoResponse userInfoResponse = (UserInfoResponse) response.getBody();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, userInfoResponse.getId());
        assertEquals("testUser", userInfoResponse.getUsername());
        assertEquals("testuser@test.com", userInfoResponse.getEmail());
        assertEquals("John", userInfoResponse.getFirstname());
        assertEquals("Doe", userInfoResponse.getLastname());
        assertEquals(1, userInfoResponse.getRoles().size());
        assertEquals("ROLE_USER", userInfoResponse.getRoles().get(0));
    }

    @Test
    void testRegisterUserNoExistsUsername(){
        ResponseEntity res = authController.registerUser(signUpRequest);
        assertEquals(res.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    void testRegisterNoExistsEmail(){
        when(userRepository.existsByUsername(any())).thenReturn(false);
        ResponseEntity res = authController.registerUser(signUpRequest);
        assertEquals(res.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    void testLogoutUser() {
        ResponseEntity<?> res = authController.logoutUser();
        assertEquals(res.getStatusCode(), HttpStatus.OK);
    }
}