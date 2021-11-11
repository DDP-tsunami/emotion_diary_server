package com.dadaepo.emo.dto.member;

import com.dadaepo.emo.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NotEmpty
public class MemberSignupRequest {
    private String userId;
    private String nickname;
    private String name;
    private String password;
    private String email;
    private Role role;
}
