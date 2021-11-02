package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.request.MemberSignupRequest;

public interface MemberService {
    void signup(MemberSignupRequest request);

    boolean isExist(String userId);
}
