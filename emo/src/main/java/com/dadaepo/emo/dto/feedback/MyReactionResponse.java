package com.dadaepo.emo.dto.feedback;

import com.dadaepo.emo.enums.Reaction;
import lombok.Getter;

@Getter
public class MyReactionResponse {
    private Reaction reaction;
    private long reactionId;
    private boolean status;
}
