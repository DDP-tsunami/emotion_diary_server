package com.dadaepo.emo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Feedback {
    private long id;
    private long memberId;
    private long memoId;
    private Reaction reaction;
    private String date;
}
