package com.dadaepo.emo.dao;

import com.dadaepo.emo.dto.notice.Notice;
import com.dadaepo.emo.dto.notice.NoticeInfo;
import com.dadaepo.emo.dto.notice.NoticeRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeDao {
    int insertNotice(NoticeRequest noticeRequest);

    List<NoticeInfo> selectNotices(int start, int limit, long memberId);

    int selectTotalCount(long memberId);

    int updateStatus(long noticeId);
}
