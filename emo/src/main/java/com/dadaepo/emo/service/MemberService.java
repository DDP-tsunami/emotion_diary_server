package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.member.*;
import com.dadaepo.emo.exception.BusinessException;

public interface MemberService {
    void signup(MemberSignupRequest request)  throws BusinessException;

    ExistResponse isUserIdExist(String userId);

    ExistResponse isEmailExist(String email);

    void updateProfile(MemberUpdateRequest request) throws BusinessException;

    Member getMyUserInfo();

    MemberInfoResponse getUserByEmail(String email);
}
