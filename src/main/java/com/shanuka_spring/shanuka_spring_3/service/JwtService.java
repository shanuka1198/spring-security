package com.shanuka_spring.shanuka_spring_3.service;

import com.shanuka_spring.shanuka_spring_3.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    // 🔹 JWT Token Generate කිරීම (User info සහ Token Expiration සමඟ)
    public String generateToken(UserEntity user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)  // 🔥 Corrected Secret Key
                .compact();
    }

    // 🔹 Secret Key Generate කිරීම (Fix)
    private SecretKey getSigningKey() {
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // 🔹 Token Validද කියලා check කිරීම (Fix)
    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    // 🔹 Token Expired ද කියලා check කිරීම
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // 🔹 Token Expiration Date එක extract කිරීම
    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    // 🔹 Claims Extract කිරීම
    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()  // Jwts.parser() භාවිතා කරන්න
                .setSigningKey(getSigningKey())
                .build()// Signing key එක set කරන්න
                .parseClaimsJws(token)  // JWT token එක parse කිරීම
                .getBody();  // Claims එක return කරන්න
    }

    // 🔹 Token එකෙන් Username එක extract කිරීම
    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }
}
