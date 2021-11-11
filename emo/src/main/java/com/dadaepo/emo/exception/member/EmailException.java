package com.dadaepo.emo.exception.member;

import com.dadaepo.emo.enums.ErrorCode;
import com.dadaepo.emo.exception.BusinessException;

public class EmailException extends BusinessException {

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.EMAIL_DUPLICATION;
    }
}
