package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.friend.FriendRequest;
import com.dadaepo.emo.dto.friend.FriendResponse;

public interface FriendService {
    void acceptFriend(FriendRequest friendRequest);

    FriendResponse getFriends();

    void deleteFriend(long memberId);
}
