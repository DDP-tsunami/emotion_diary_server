package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.Member;
import com.dadaepo.emo.dto.request.MemberSignupRequest;
import com.dadaepo.emo.dto.request.MemberUpdateRequest;

public interface MemberService {
    void signup(MemberSignupRequest request);

    boolean isExist(String userId);

    void updateProfile(MemberUpdateRequest request);

    Member getMyUserInfo();
}
