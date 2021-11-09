package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.notice.NoticeResponse;
import com.dadaepo.emo.enums.NoticeType;

public interface NoticeService {
    int NOTICE_LIMIT = 5;

    NoticeResponse getNotices(int start, NoticeType noticeType);

}
