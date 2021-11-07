package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.memo.EmotionDetailResponse;
import com.dadaepo.emo.dto.memo.EmotionRequest;
import com.dadaepo.emo.dto.memo.LineResponse;
import com.dadaepo.emo.dto.memo.MemoResponse;

public interface MemoService {
    int FEED_LIMIT = 5;

    void addMemo(EmotionRequest emotionRequest);

    MemoResponse getMemoForMonth(String month);

    LineResponse getFeed(int start);

    EmotionDetailResponse getEmotionDetail(long emotionId);
}
