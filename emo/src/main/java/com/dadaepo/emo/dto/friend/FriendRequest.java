package com.dadaepo.emo.dto.friend;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class FriendRequest {
    @NotEmpty private long noticeId;
    private long meId;
    @NotEmpty private long youId;
}
