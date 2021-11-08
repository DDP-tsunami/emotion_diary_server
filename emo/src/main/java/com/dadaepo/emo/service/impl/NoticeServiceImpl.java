package com.dadaepo.emo.service.impl;

import com.dadaepo.emo.dao.MemberDao;
import com.dadaepo.emo.dao.NoticeDao;
import com.dadaepo.emo.dto.member.Member;
import com.dadaepo.emo.dto.notice.NoticeInfo;
import com.dadaepo.emo.dto.notice.NoticeRequest;
import com.dadaepo.emo.dto.notice.NoticeResponse;
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
    public void sendNotice(NoticeRequest noticeRequest) {
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());
        noticeRequest.setSendId(member.getId());

        int insertNotice = noticeDao.insertNotice(noticeRequest);
        if (insertNotice != 1) {
            log.error("알림 보내기를 실패하였습니다.");
        }
    }

    @Override
    public NoticeResponse getNotices(int start) {
        NoticeResponse noticeResponse = new NoticeResponse();
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());
        List<NoticeInfo> notices = noticeDao.selectNotices(start, NOTICE_LIMIT, member.getId());

        for (NoticeInfo noticeInfo : notices) {
            noticeInfo.setSender(memberDao.selectUserByMemberId(noticeInfo.getSendId()));
        }
        noticeResponse.setNotices(notices);
        noticeResponse.setTotalCount(noticeDao.selectTotalCount(member.getId()));
        return noticeResponse;
    }

    @Override
    public void checkNotice(long noticeId) {
        int updateStatus = noticeDao.updateStatus(noticeId);
        if (updateStatus != 1) {
            log.error("알림 확인 업데이트를 실패하였습니다.");
        }
    }
}
