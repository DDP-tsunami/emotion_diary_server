package com.dadaepo.emo.dto.feedback;

import com.dadaepo.emo.enums.Reaction;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReactionRequest {
    private long memberId;
    private long memoId;
    private Reaction reaction;
}
