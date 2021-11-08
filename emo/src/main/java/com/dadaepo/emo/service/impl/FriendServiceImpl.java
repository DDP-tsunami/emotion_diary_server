package com.dadaepo.emo.service.impl;

import com.dadaepo.emo.dao.FriendDao;
import com.dadaepo.emo.dao.MemberDao;
import com.dadaepo.emo.dao.NoticeDao;
import com.dadaepo.emo.dto.friend.FriendRequest;
import com.dadaepo.emo.dto.friend.FriendResponse;
import com.dadaepo.emo.dto.member.Member;
import com.dadaepo.emo.dto.member.MemberInfo;
import com.dadaepo.emo.dto.notice.NoticeRequest;
import com.dadaepo.emo.service.FriendService;
import com.dadaepo.emo.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendDao friendDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public void sendFriendNotice(NoticeRequest noticeRequest) {
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());
        noticeRequest.setSendId(member.getId());

        int insertNotice = noticeDao.insertNotice(noticeRequest);
        if (insertNotice != 1) {
            log.error("친구 알림 보내기를 실패하였습니다.");
        }
    }

    @Override
    public void acceptFriend(FriendRequest friendRequest) {
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());
        friendRequest.setMeId(member.getId());
        int insertFriend = friendDao.insertFriend(friendRequest);
        if (insertFriend != 1) {
            log.error("친구 등록 중 에러가 발생하였습니다.");
        }
    }

    @Override
    public FriendResponse getFriends() {
        FriendResponse friendResponse = new FriendResponse();
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());

        List<MemberInfo> friendList = friendDao.selectFriends(member.getId());
        friendResponse.setFriends(friendList);
        friendResponse.setCountFriends(friendList.size());

        return friendResponse;
    }

    @Override
    public void deleteFriend(long deleteMemberId) {
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());

        int deleteFriend = friendDao.deleteFriend(deleteMemberId, member.getId());
        if (deleteFriend != 1) {
            log.error("친구 삭제 중 에러가 발생하였습니다.");
        }
    }

}
