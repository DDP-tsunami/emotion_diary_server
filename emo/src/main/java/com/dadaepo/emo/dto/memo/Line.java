package com.dadaepo.emo.dto.memo;

import com.dadaepo.emo.enums.Emotion;
import lombok.Getter;

@Getter
public class Line {
    private long id;
    private long memberId;
    private String profilePhotoUrl;
    private String name;
    private String nickname;
    private Emotion emotion;
    private boolean emotionScope;
    private boolean detailScope;
    private String date;
}
