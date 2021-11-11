package com.dadaepo.emo.controller;

import com.dadaepo.emo.config.jwt.JwtFilter;
import com.dadaepo.emo.config.jwt.TokenProvider;
import com.dadaepo.emo.dto.member.Token;
import com.dadaepo.emo.dto.member.LoginRequest;
import com.dadaepo.emo.exception.member.LoginException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Api("인증")
@Slf4j
@RestController
@RequestMapping("/api/authentication")
public class AuthController {

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @ApiOperation(value = "로그인")
    @PostMapping(value = "/login")
    public ResponseEntity<Token> login(@RequestBody LoginRequest loginRequest) throws LoginException {
        try{
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserId(), loginRequest.getPassword());
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.createToken(authentication);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

            return new ResponseEntity<>(new Token(jwt), httpHeaders, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            throw new LoginException();
        }
    }

}
