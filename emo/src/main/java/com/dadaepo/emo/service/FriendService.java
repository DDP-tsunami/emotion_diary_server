package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.friend.FriendRequest;
import com.dadaepo.emo.dto.friend.FriendResponse;
import com.dadaepo.emo.dto.notice.NoticeRequest;
import org.springframework.transaction.annotation.Transactional;

public interface FriendService {
    void acceptFriend(FriendRequest friendRequest);

    FriendResponse getFriends();

    void deleteFriend(long memberId);

    @Transactional
    void sendFriendNotice(NoticeRequest noticeRequest);
}
