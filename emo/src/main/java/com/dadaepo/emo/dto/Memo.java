package com.dadaepo.emo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Memo {
    private long id;
    private long memberId;
    private Emotion emotion;
    private boolean emotionScope;
    private String detail;
    private boolean detailScope;
    private String date;
}
