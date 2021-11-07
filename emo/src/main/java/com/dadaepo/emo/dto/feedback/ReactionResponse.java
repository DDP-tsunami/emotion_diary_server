package com.dadaepo.emo.dto.feedback;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReactionResponse {
    private List<ReactionInfo> reactions;
}
