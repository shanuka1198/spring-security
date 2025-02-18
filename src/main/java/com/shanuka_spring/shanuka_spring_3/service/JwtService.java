package com.shanuka_spring.shanuka_spring_3.service;

import com.shanuka_spring.shanuka_spring_3.entity.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private final String secretKey="qLhT/XZQhV8K7f5S6wG2PdA9YZ/v0JpN4DkM2LmRuSo=";

    public String generateToken(UserEntity user){

        Map<String,Object>claims=new HashMap<>();
        claims.put("email",user.getEmail());
        claims.put("role",user.getRole());

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(user.getUsername())
                .issuer("DCB")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+60*10*100))
                .and()
                .signWith(generateKey())
                .compact();
    }

    private Key generateKey() {

        byte[] decode= Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(decode);

    }
}
