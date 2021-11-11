package com.dadaepo.emo.dto.Error;

import com.dadaepo.emo.enums.ErrorCode;
import lombok.Getter;

@Getter
public class ErrorResponse {
    public ErrorResponse(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
    }
    private String message;
    private int status;
    private String code;

}
