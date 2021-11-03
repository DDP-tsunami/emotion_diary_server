package com.dadaepo.emo.dto.memo;

import com.dadaepo.emo.enums.Emotion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Memo {
    private long id;
    private long memberId;
    private String profilePhotoUrl;
    private String name;
    private String nickname;
    private Emotion emotion;
    private boolean emotionScope;
    private String detail;
    private boolean detailScope;
    private String date;
}
