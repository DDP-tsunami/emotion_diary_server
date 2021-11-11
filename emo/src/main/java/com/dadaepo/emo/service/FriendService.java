package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.friend.FriendRequest;
import com.dadaepo.emo.dto.friend.FriendResponse;
import com.dadaepo.emo.dto.notice.NoticeRequest;
import com.dadaepo.emo.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

public interface FriendService {
    @Transactional
    boolean acceptFriend(FriendRequest friendRequest) throws BusinessException;

    FriendResponse getFriends();

    void deleteFriend(long memberId) throws BusinessException;

    @Transactional
    void sendFriendNotice(NoticeRequest noticeRequest) throws BusinessException;

    void deleteFriendNotice(long noticeId) throws BusinessException;
}
