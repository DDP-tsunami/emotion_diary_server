package com.dadaepo.emo.dto.member;

import lombok.Data;

@Data
public class LoginRequest {
    private String userId;
    private String password;
}
