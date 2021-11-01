package com.dadaepo.emo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private long id;
    private String userId;
    private String nickname;
    private String code;
    private String profilePhotoUrl;
    private String name;
    private String password;
    private String timestamp;
}
