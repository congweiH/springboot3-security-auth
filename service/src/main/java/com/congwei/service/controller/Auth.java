package com.congwei.service.controller;

import com.congwei.service.model.myuser.MyUserDetailService;
import com.congwei.service.webtoken.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Auth {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @PostMapping("/authenticate")
    public String authAndGetToken(@RequestBody LoginForm loginForm) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginForm.getUsername(),
                loginForm.getPassword()
        ));

        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(myUserDetailService.loadUserByUsername(loginForm.getUsername()));
        } else {
            throw new UsernameNotFoundException(("invalid credential"));
        }
    }

}
