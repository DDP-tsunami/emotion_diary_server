package com.dadaepo.emo.dao;

import com.dadaepo.emo.dto.friend.FriendRequest;
import com.dadaepo.emo.dto.member.Member;
import com.dadaepo.emo.dto.member.MemberInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendDao {

    int insertFriend(FriendRequest friendRequest);

    List<MemberInfo> selectFriends(long memberId);

    int deleteFriend(long deleteMemberId, long meId);

    int deleteFriendNotice(long noticeId);

    Long isFriend(long meId, long youId);
}
