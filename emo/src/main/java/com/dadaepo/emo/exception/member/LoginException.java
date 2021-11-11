package com.dadaepo.emo.exception.member;

import com.dadaepo.emo.enums.ErrorCode;
import com.dadaepo.emo.exception.BusinessException;

public class LoginException extends BusinessException {

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.LOGIN_INPUT_INVALID;
    }
}
