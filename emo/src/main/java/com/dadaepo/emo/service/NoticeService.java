package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.notice.NoticeRequest;
import com.dadaepo.emo.dto.notice.NoticeResponse;

public interface NoticeService {
    int NOTICE_LIMIT = 10;

    void sendNotice(NoticeRequest noticeRequest);

    NoticeResponse getNotices(int start);

    void checkNotice(long noticeId);

    void deleteNotice(long noticeId);
}
