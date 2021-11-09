package com.dadaepo.emo.dto.feedback;

import com.dadaepo.emo.enums.NoticeType;
import com.dadaepo.emo.enums.Reaction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReactionRequest {
    private long reactionId;

    private long memoId;
    private Reaction reaction;

    private long sendId;
    private long receiveId;
    private NoticeType type;
}
