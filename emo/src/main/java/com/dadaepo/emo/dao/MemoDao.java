package com.dadaepo.emo.dao;

import com.dadaepo.emo.dto.memo.EmotionRequest;
import com.dadaepo.emo.dto.memo.Line;
import com.dadaepo.emo.dto.memo.Memo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoDao {
    int insertMemo(EmotionRequest emotionRequest);

    List<Memo> selectMemoForMonth(int year, int nextYear, int month, int nextMonth, long memberId);

    List<Line> selectFeed(int start, int feedLimit, long memberId);

    int countFeedByUserId(long memberId);
}
