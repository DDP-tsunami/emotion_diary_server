package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.memo.*;
import org.springframework.transaction.annotation.Transactional;

public interface MemoService {
    int FEED_LIMIT = 5;

    @Transactional
    void addMemo(EmotionRequest emotionRequest);

    MemoResponse getMemoForMonth(String month);

    LineResponse getFeed(int start);

    EmotionDetailResponse getEmotionDetail(long emotionId);

    MemoResponse getEmotionToday();
}
