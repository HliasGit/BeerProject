package com.pintbid.project.backend.security;

import com.pintbid.project.backend.security.services.UserDetailsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseCookie;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.token.Token;
import org.springframework.test.util.ReflectionTestUtils;

import javax.servlet.http.Cookie;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtUtilsTest {

    @MockBean
    private MockHttpServletRequest request;

    @MockBean
    private Cookie cookie;

    @Autowired
    private JwtUtils jwtUtils;

    @BeforeEach
    void setup(){
        request = new MockHttpServletRequest();
        cookie = new Cookie("jwtCookieName", "jwtCookieValue");
    }

    @Test
    void tesGetJwtFromCookies() {
        ReflectionTestUtils.setField(jwtUtils, "jwtCookie", "jwtCookieName");
        request.setCookies(cookie);
        String res = jwtUtils.getJwtFromCookies(request);
        assertEquals("jwtCookieValue", res);
    }

    @Test
    void testGenerateJwtCookie(){
        ReflectionTestUtils.setField(jwtUtils, "jwtCookie", "CookieName");
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        UserDetailsImpl user = new UserDetailsImpl(12, false, "John", "Johnny", "Test", "email", "password", list);
        ResponseCookie res = jwtUtils.generateJwtCookie(user);
        assertEquals("CookieName",res.getName());
    }

    @Test
    void testGetCleanJwtCookie(){
        ReflectionTestUtils.setField(jwtUtils, "jwtCookie", "CookieCleaned");
        ResponseCookie res = jwtUtils.getCleanJwtCookie();
        assertEquals("CookieCleaned",res.getName());
    }

    @Test
    void testGenerateTokenFromUsername(){
        String res = jwtUtils.generateTokenFromUsername("Pippo");
        ReflectionTestUtils.setField(jwtUtils, "jwtExpirationMs", 433);
        ReflectionTestUtils.setField(jwtUtils, "jwtSecret", "Cane");
        assertEquals(174, res.length());
    }
}