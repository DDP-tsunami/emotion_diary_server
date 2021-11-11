package com.dadaepo.emo.exception.memo;

import com.dadaepo.emo.enums.ErrorCode;
import com.dadaepo.emo.exception.BusinessException;

public class MemoDuplicationException extends BusinessException {

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.EMOTION_DUPLICATION;
    }
}
