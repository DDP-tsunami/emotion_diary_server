package com.dadaepo.emo.dto.request;

import com.dadaepo.emo.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignupRequest {
    private String userId;
    private String nickname;
    private String name;
    private String password;
    private String email;
    private Role role;
}
