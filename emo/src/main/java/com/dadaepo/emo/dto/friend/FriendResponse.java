package com.dadaepo.emo.dto.friend;

import com.dadaepo.emo.dto.member.MemberInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FriendResponse {
    private List<MemberInfo> friends;
    private int countFriends;
}
