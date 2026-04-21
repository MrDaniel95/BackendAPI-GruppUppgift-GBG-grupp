package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // Den hemliga nyckeln som servern använder för att signera tokens
    private final byte[] secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();

    // Token är giltig i 1 timme (i millisekunder)
    private final long EXPIRATION_TIME = 1000 * 60 * 60;


    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)                          // Vem token tillhör
                .setIssuedAt(new Date())                       // När skapades den?
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // När går den ut?
                .signWith(Keys.hmacShaKeyFor(secretKey))       // Signera med hemliga nyckeln
                .compact();                                    // Bygg ihop till en sträng
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey))  // Använd samma nyckel för att läsa
                .build()
                .parseClaimsJws(token)                         // Läs och verifiera token
                .getBody()                                     // Hämta payloaden
                .getSubject();                                 // Hämta användarnamnet
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secretKey))  // Samma nyckel
                    .build()
                    .parseClaimsJws(token);                        // Försök läsa token
            return true;                                           // Inga fel = token är giltig
        } catch (Exception e) {
            return false;                                          // Något gick fel = ogiltig
        }
    }
}