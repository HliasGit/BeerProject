package com.pintbid.project.backend.api;

import com.pintbid.project.backend.payload.request.LoginRequest;
import com.pintbid.project.backend.payload.response.UserInfoResponse;
import com.pintbid.project.backend.repository.RoleRepository;
import com.pintbid.project.backend.repository.UserRepository;
import com.pintbid.project.backend.security.JwtUtils;
import com.pintbid.project.backend.security.services.UserDetailsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class AuthControllerTest {

    //Login request
    LoginRequest loginRequest = new LoginRequest();

    //Authentication obj
    Authentication authentication = Mockito.mock(Authentication.class);


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
        loginRequest.setUsername("testUser");
        loginRequest.setPassword("password");
        when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()))).thenReturn(authentication);


    }

    @Test
    void testAuthenticateUser() {
        //GrantedAuthority
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));

        //UserDetailsImpl
        UserDetailsImpl userDetails = new UserDetailsImpl(1, "John", "testUser", "Doe", "testuser@test.com", "password", list);

        when(authentication.getPrincipal()).thenReturn(userDetails);

        // set up the mocked return values for the method calls
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);

        ResponseCookie jwtCookie = ResponseCookie.from("token", "JWT_TOKEN").build();
        when(jwtUtils.generateJwtCookie(userDetails)).thenReturn(jwtCookie);

        // call the method under test
        ResponseEntity<?> response = authController.authenticateUser(loginRequest);

        UserInfoResponse userInfoResponse = (UserInfoResponse) response.getBody();

        // assert the expected results
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
    void testRegisterUser() {
    }

    @Test
    void testLogoutUser() {
    }
}