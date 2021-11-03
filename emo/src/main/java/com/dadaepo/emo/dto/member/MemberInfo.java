package com.dadaepo.emo.dto.member;

import lombok.Getter;

@Getter
public class MemberInfo {
    private long id;
    private String userId;
    private String email;
    private String name;
    private String nickname;
    private String profilePhotoUrl;
    private String date;
}
