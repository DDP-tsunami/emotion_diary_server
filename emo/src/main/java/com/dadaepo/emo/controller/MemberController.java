package com.dadaepo.emo.controller;

import com.dadaepo.emo.dto.request.MemberSignupRequest;
import com.dadaepo.emo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping(value = "/signup")
    public ResponseEntity<Object> signup(@RequestBody MemberSignupRequest request) {
        memberService.signup(request);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping(value = "/existence")
    public ResponseEntity<Object> isExist(@RequestParam("userId") String userId) {
        String exist = "false";
        if(memberService.isExist(userId)) {
            exist = "true";
        }
        return new ResponseEntity<>(exist, HttpStatus.OK);
    }
}