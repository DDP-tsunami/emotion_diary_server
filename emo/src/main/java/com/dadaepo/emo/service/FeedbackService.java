package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.feedback.MyReactionResponse;
import com.dadaepo.emo.dto.feedback.ReactionRequest;
import com.dadaepo.emo.dto.feedback.ReactionResponse;
import org.springframework.transaction.annotation.Transactional;

public interface FeedbackService {
    @Transactional
    void addReaction(ReactionRequest reactionRequest);

    ReactionResponse getReactions(long memoId);

    @Transactional
    void updateReaction(ReactionRequest reactionRequest);

    @Transactional
    void deleteReaction(long reactionId);

    MyReactionResponse getMyReactionStatus(long memoId);
}
