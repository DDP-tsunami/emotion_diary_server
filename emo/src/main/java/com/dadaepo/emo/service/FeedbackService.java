package com.dadaepo.emo.service;

import com.dadaepo.emo.dto.feedback.MyReactionResponse;
import com.dadaepo.emo.dto.feedback.ReactionRequest;
import com.dadaepo.emo.dto.feedback.ReactionResponse;
import com.dadaepo.emo.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

public interface FeedbackService {
    @Transactional
    void addReaction(ReactionRequest reactionRequest) throws BusinessException;

    ReactionResponse getReactions(long memoId);

    @Transactional
    void updateReaction(ReactionRequest reactionRequest) throws BusinessException;

    @Transactional
    void deleteReaction(long reactionId) throws BusinessException;

    MyReactionResponse getMyReactionStatus(long memoId);
}
