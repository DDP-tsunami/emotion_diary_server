package com.dadaepo.emo.dto.feedback;

import com.dadaepo.emo.enums.Reaction;
import lombok.Getter;

@Getter
public class ReactionInfo {
    private Reaction reaction;
    private String photoUrl;
    private String name;
    private String nickname;
    private long id;
}
