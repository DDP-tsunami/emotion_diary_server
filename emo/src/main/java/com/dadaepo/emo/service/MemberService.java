package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.member.*;

public interface MemberService {
    void signup(MemberSignupRequest request);

    boolean isExist(String userId);

    void updateProfile(MemberUpdateRequest request);

    Member getMyUserInfo();

    MemberInfoResponse getUserByEmail(String email);
}
