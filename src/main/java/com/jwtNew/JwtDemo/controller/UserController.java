package com.jwtNew.JwtDemo.controller;

import com.jwtNew.JwtDemo.Authentication.JwtAuth;
import com.jwtNew.JwtDemo.Authentication.JwtValidator;
import com.jwtNew.JwtDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private JwtAuth jwtAuth;

    @Autowired
    private JwtValidator jwtValidator;

    @PostMapping("/getJwt")
    public String getJwt(@RequestBody User user){
        return jwtAuth.generateJwtToken(user);
    }

    @GetMapping("/checkJwt")
    public String checkJwt(@RequestBody String Token){
        System.out.println("Token : "+Token);
//        String newToken=Token.get("Token");
//        System.out.println("new Token : "+newToken);
        return jwtValidator.validation(Token);
    }
}
