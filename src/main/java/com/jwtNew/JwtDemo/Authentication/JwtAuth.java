package com.jwtNew.JwtDemo.Authentication;

import com.jwtNew.JwtDemo.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtAuth {

    @Value("${jwt.secretKey}")
    private String secretKey;

    public SecretKey secretKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }


    public String generateJwtToken(User user){

        System.out.println("secretKey : "+secretKey);

        return Jwts.builder()
                .subject(user.getUserName())
                .claim("userPassword",user.getUserPassword())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*10))
                .signWith(secretKey())
                .compact();
    }



}
