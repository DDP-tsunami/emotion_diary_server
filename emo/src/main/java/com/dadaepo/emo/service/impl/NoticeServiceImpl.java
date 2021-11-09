package com.dadaepo.emo.service.impl;

import com.dadaepo.emo.dao.MemberDao;
import com.dadaepo.emo.dao.NoticeDao;
import com.dadaepo.emo.dto.member.Member;
import com.dadaepo.emo.dto.notice.NoticeInfo;
import com.dadaepo.emo.dto.notice.NoticeResponse;
import com.dadaepo.emo.enums.NoticeType;
import com.dadaepo.emo.service.NoticeService;
import com.dadaepo.emo.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private MemberDao memberDao;

    @Override
    public NoticeResponse getNotices(int start, NoticeType noticeType) {
        NoticeResponse noticeResponse;
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());

        if(noticeType == NoticeType.REACTION) {
            noticeResponse = getReactionNotices(start, member.getId());
        } else {
            noticeResponse = getFriendNotices(start, member.getId());
        }

        return noticeResponse;
    }

    private NoticeResponse getFriendNotices(int start, long memberId) {
        NoticeResponse noticeResponse = new NoticeResponse();
        List<NoticeInfo> notices = noticeDao.selectFriendNotices(start, NOTICE_LIMIT, memberId);

        for (NoticeInfo noticeInfo : notices) {
            noticeInfo.setSender(memberDao.selectUserByMemberId(noticeInfo.getSendId()));
        }
        noticeResponse.setNotices(notices);
        noticeResponse.setTotalCount(noticeDao.selectTotalCountFriendNotice(memberId));

        return noticeResponse;
    }

    private NoticeResponse getReactionNotices(int start, long memberId) {
        NoticeResponse noticeResponse = new NoticeResponse();
        List<NoticeInfo> notices = noticeDao.selectReactionNotices(start, NOTICE_LIMIT, memberId);

        for (NoticeInfo noticeInfo : notices) {
            noticeInfo.setSender(memberDao.selectUserByMemberId(noticeInfo.getSendId()));
        }
        noticeResponse.setNotices(notices);
        noticeResponse.setTotalCount(noticeDao.selectTotalCountReactionNotice(memberId));

        return noticeResponse;
    }

}
