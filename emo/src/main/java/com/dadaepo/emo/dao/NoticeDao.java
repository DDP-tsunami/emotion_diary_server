package com.dadaepo.emo.dao;

import com.dadaepo.emo.dto.notice.NoticeInfo;
import com.dadaepo.emo.dto.notice.NoticeRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeDao {
    int insertFriendNotice(NoticeRequest noticeRequest);
    int insertReactionNotice(NoticeRequest noticeRequest,@Param("reactionId") long reactionId);

    List<NoticeInfo> selectReactionNotices(int start, int limit, long memberId);
    List<NoticeInfo> selectFriendNotices(int start, int limit, long memberId);

    int selectTotalCountFriendNotice(long memberId);
    int selectTotalCountReactionNotice(long memberId);

    int deleteReactionNotice(long reactionId);
}
