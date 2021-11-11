package com.dadaepo.emo.exception.friend;

import com.dadaepo.emo.enums.ErrorCode;
import com.dadaepo.emo.exception.BusinessException;

public class FriendDuplicationException extends BusinessException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.FRIEND_DUPLICATION;
    }
}
