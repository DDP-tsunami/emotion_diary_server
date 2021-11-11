package com.dadaepo.emo.exception;

import com.dadaepo.emo.enums.ErrorCode;

public class BusinessException extends Exception{
    private ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return ErrorCode.BUSINESS_LOGIC_ERROR;
    }
}
