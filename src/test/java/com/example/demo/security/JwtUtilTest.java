package com.example.demo.security;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JwtUtilTest {

    private final JwtUtil jwtUtil = new JwtUtil();

    @Test
    void shouldGenerateValidToken() {
        String token = jwtUtil.generateToken("testuser");

        assertNotNull(token);
        assertTrue(token.length() > 10);
    }

    @Test
    void shouldExtractUsernameFromToken() {
        String token = jwtUtil.generateToken("testuser");

        String username = jwtUtil.extractUsername(token);

        assertEquals("testuser", username);
    }

    @Test
    void shouldValidateToken() {
        String token = jwtUtil.generateToken("testuser");

        boolean isValid = jwtUtil.validateToken(token);

        assertTrue(isValid);
    }

    @Test
    void shouldFailForInvalidToken() {
        boolean isValid = jwtUtil.validateToken("fake.token.here");

        assertFalse(isValid);
    }
}
