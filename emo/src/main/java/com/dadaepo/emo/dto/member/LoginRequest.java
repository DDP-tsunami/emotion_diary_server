package com.dadaepo.emo.dto.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@NotEmpty
public class LoginRequest {
    private String userId;
    private String password;
}
