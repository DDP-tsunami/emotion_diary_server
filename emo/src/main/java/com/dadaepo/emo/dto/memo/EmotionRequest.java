package com.dadaepo.emo.dto.memo;

import com.dadaepo.emo.enums.Emotion;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class EmotionRequest {
    private long memberId;
    private Emotion emotion;
    private boolean emotionScope;
    private String detail;
    private boolean detailScope;
}
