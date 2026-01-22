package com.jwtNew.JwtDemo.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
@Component
public class JwtValidator {

    @Autowired
    private JwtAuth jwtAuth;



    public String validation(String token){
        try {
            Claims claims= Jwts.parser()
                    .verifyWith(jwtAuth.secretKey())
                            .build()
                                    .parseClaimsJws(token)
                                            .getBody();
            System.out.println("claims : "+claims);
            System.out.println("user : "+claims.getSubject());
            return ("token is valid");
        } catch (Exception e) {
            return ("Invalid Token!!!");
        }
    }
}
