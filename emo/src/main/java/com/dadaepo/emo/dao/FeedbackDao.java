package com.dadaepo.emo.dao;

import com.dadaepo.emo.dto.feedback.ReactionInfo;
import com.dadaepo.emo.dto.feedback.ReactionRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackDao {
    int insertReaction(ReactionRequest reactionRequest);

    List<ReactionInfo> selectReactions(long memoId);

    List<Integer> selectCountReactionByType(long memoId);
}
