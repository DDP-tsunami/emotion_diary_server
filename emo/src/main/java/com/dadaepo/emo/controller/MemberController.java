package com.dadaepo.emo.controller;

import com.dadaepo.emo.dto.member.*;
import com.dadaepo.emo.exception.BusinessException;
import com.dadaepo.emo.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api("회원 관리")
@RestController
@RequestMapping("/api/user")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "회원 가입")
    @PostMapping(value = "/signup")
    public ResponseEntity<Object> signup(@RequestBody @Valid MemberSignupRequest request) throws Exception  {
        memberService.signup(request);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @ApiOperation(value = "내 정보 찾기")
    @GetMapping(value = "")
    public ResponseEntity<Member> getMyUserInfo() {
        return ResponseEntity.ok(memberService.getMyUserInfo());
    }

    @ApiOperation(value = "회원 아이디 중복 확인")
    @GetMapping(value = "/existence/userId")
    public ResponseEntity<ExistResponse> isUserIdExist(@RequestParam("userId") String userId) {
        return ResponseEntity.ok(memberService.isUserIdExist(userId));
    }

    @ApiOperation(value = "회원 이메일 중복 확인")
    @GetMapping(value = "/existence/email")
    public ResponseEntity<ExistResponse> isEmailExist(@RequestParam("email") String email) {
        return ResponseEntity.ok(memberService.isEmailExist(email));
    }

    @ApiOperation(value = "프로필 변경")
    @PutMapping(value = "/profile")
    public ResponseEntity<Object> updateProfile(@RequestBody MemberUpdateRequest request) throws BusinessException {
        memberService.updateProfile(request);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @ApiOperation(value = "회원 찾기")
    @GetMapping(value = "/search")
    public ResponseEntity<MemberInfoResponse> getUserByEmail(@RequestParam(value = "email", defaultValue = "") String email) {
        return ResponseEntity.ok(memberService.getUserByEmail(email));
    }

}
