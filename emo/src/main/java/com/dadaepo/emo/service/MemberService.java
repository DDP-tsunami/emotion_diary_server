package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.member.Member;
import com.dadaepo.emo.dto.member.MemberSignupRequest;
import com.dadaepo.emo.dto.member.MemberUpdateRequest;

public interface MemberService {
    void signup(MemberSignupRequest request);

    boolean isExist(String userId);

    void updateProfile(MemberUpdateRequest request);

    Member getMyUserInfo();
}
