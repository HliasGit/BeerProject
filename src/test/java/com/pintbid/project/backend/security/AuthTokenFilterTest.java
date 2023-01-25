package com.pintbid.project.backend.security;

import com.pintbid.project.backend.security.services.UserDetailsImpl;
import com.pintbid.project.backend.security.services.UserDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class AuthTokenFilterTest {

    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    MockFilterChain chain = new MockFilterChain();
    Cookie cookie = new Cookie("TestName", "TestValue");
    List<GrantedAuthority> list = new ArrayList<>();
    UserDetails user;

    @MockBean
    private JwtUtils jwtUtils;

    @MockBean
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthTokenFilter authTokenFilter;

    @BeforeEach
    void setup(){
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        user = new UserDetailsImpl(14, false, "Name", "Username", "Lastname", "email", "password", list);
        request.setCookies(cookie);
        when(jwtUtils.getUserNameFromJwtToken(any())).thenReturn("UserNameFromToken");
        when(jwtUtils.validateJwtToken(any())).thenReturn(true);
        when(jwtUtils.getJwtFromCookies(any())).thenReturn("JwtFromCookies");
        when(userDetailsService.loadUserByUsername(any())).thenReturn(user);
    }

    @Test
    void doFilterInternal() throws ServletException, IOException {
        authTokenFilter.doFilterInternal(request, response, chain);
        verify(jwtUtils).validateJwtToken(any());
    }
}