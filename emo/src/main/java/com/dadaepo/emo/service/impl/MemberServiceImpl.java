package com.dadaepo.emo.service.impl;

import com.dadaepo.emo.dao.MemberDao;
import com.dadaepo.emo.dto.member.*;
import com.dadaepo.emo.enums.NoticeType;
import com.dadaepo.emo.enums.Role;
import com.dadaepo.emo.exception.BusinessException;
import com.dadaepo.emo.exception.member.EmailException;
import com.dadaepo.emo.exception.member.UserIdException;
import com.dadaepo.emo.service.MemberService;
import com.dadaepo.emo.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void signup(MemberSignupRequest request) throws BusinessException {

        checkDuplication(request);

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
            throw new BusinessException();
        }
    }

    @Override
    public ExistResponse isUserIdExist(String newUserId) {
        ExistResponse existResponse;
        String userId = memberDao.selectUserId(newUserId);
        if (userId == null) {
            existResponse = new ExistResponse(false);
        } else {
            existResponse = new ExistResponse(true);
        }
        return existResponse;
    }

    @Override
    public ExistResponse isEmailExist(String newEmail) {
        ExistResponse existResponse;
        String email = memberDao.selectUserEmail(newEmail);
        if (email == null) {
            existResponse = new ExistResponse(false);
        } else {
            existResponse = new ExistResponse(true);
        }
        return existResponse;
    }

    private void checkDuplication(MemberSignupRequest request) throws BusinessException{
        String userId = memberDao.selectUserId(request.getUserId());
        String email = memberDao.selectUserEmail(request.getEmail());
        if(userId != null && userId.equals(request.getUserId())) {
            throw new UserIdException();
        } else if(email != null && email.equals(request.getEmail())) {
            throw new EmailException();
        }
    }

    @Override
    public void updateProfile(MemberUpdateRequest request) throws BusinessException {
        String userId = getCurrentUsername();
        int updateMember = memberDao.updateProfile(request, userId);
        if(updateMember < 0) {
            log.error("프로필 수정 중 에러가 발생하였습니다.");
            throw new BusinessException();
        }
    }

    @Override
    public Member getMyUserInfo() {
        String userId = getCurrentUsername();
        return memberDao.selectUserByUserId(userId);
    }

    @Override
    public MemberInfoResponse getUserByEmail(String email) {
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());
        MemberInfoResponse memberInfos = new MemberInfoResponse();

        if(email.equals("")) {
            return memberInfos;
        }
        memberInfos.setMemberInfoList(memberDao.selectUsersByEmail(email, member.getId(), NoticeType.FRIEND_REQUEST));

        return memberInfos;
    }
}
