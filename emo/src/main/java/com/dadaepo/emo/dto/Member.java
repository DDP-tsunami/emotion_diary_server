package com.dadaepo.emo.dto;

import com.dadaepo.emo.enums.Role;
import lombok.*;

@Builder
@Data
public class Member{
    private long id;
    private String userId;
    private String email;
    private String name;
    private String nickname;
    private String profilePhotoUrl;
    private String password;
    private Role role;
    private String date;
}
