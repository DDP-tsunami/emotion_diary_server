package com.dadaepo.emo.service.impl;

import com.dadaepo.emo.dao.MemberDao;
import com.dadaepo.emo.dto.Member;
import com.dadaepo.emo.dto.request.MemberSignupRequest;
import com.dadaepo.emo.dto.request.MemberUpdateRequest;
import com.dadaepo.emo.enums.Role;
import com.dadaepo.emo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

import static com.dadaepo.emo.util.SecurityUtil.getCurrentUsername;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MemberDao memberDao;

    @Override
    @Transactional
    public void signup(MemberSignupRequest request) {

        Member member = Member.builder()
                            .userId(request.getUserId())
                            .nickname(request.getNickname())
                            .email(request.getEmail())
                            .name(request.getName())
                            .password(passwordEncoder.encode(request.getPassword()))
                            .role(Role.USER)
                            .build();
        int insertMember = memberDao.insertMember(member);
        if(insertMember < 0) {
            log.error("회원가입 중 에러가 발생하였습니다.");
        }
    }

    @Override
    public boolean isExist(String newUserId) {
        Member member = memberDao.selectUserByUserId(newUserId);
        if (member == null) {
            return false;
        }
        return true;
    }

    @Override
    public void updateProfile(MemberUpdateRequest request) {
        Optional<String> userId = getCurrentUsername();
        System.out.println(userId);
//        int updateMember = memberDao.updateProfile(request);
//        if(updateMember < 0) {
//            log.error("프로필 수정 중 에러가 발생하였습니다.");
//        }
    }
}
