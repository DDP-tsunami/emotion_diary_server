package com.dadaepo.emo.dto.member;

import com.dadaepo.emo.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter

public class MemberSignupRequest {
    @NotEmpty private String userId;
    @NotEmpty private String nickname;
    @NotEmpty private String name;
    @NotEmpty private String password;
    @NotEmpty private String email;
    private Role role;
}
