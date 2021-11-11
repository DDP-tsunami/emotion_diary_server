package com.dadaepo.emo.exception.member;

import com.dadaepo.emo.enums.ErrorCode;
import com.dadaepo.emo.exception.BusinessException;

public class UserIdException extends BusinessException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.USERID_DUPLICATION;
    }
}
