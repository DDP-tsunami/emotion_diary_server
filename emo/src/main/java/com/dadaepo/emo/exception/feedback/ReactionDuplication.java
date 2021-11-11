package com.dadaepo.emo.exception.feedback;

import com.dadaepo.emo.enums.ErrorCode;
import com.dadaepo.emo.exception.BusinessException;

public class ReactionDuplication extends BusinessException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.REACTION_DUPLICATION;
    }

}
