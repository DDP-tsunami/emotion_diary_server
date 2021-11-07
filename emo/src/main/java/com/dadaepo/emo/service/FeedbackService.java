package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.feedback.ReactionRequest;
import com.dadaepo.emo.dto.feedback.ReactionResponse;

public interface FeedbackService {
    void addReaction(ReactionRequest reactionRequest);

    ReactionResponse getReactions(long memoId);
}
