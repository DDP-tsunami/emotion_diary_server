package com.dadaepo.emo.dao;

import com.dadaepo.emo.dto.feedback.MyReactionResponse;
import com.dadaepo.emo.dto.feedback.ReactionInfo;
import com.dadaepo.emo.dto.feedback.ReactionRequest;
import com.dadaepo.emo.enums.Reaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackDao {
    int insertReaction(ReactionRequest reactionRequest);

    List<ReactionInfo> selectReactions(long memoId);

    List<Integer> selectCountReactionByType(long memoId);

    MyReactionResponse selectMyReactionStatus(long memoId, long sendId);

    int updateReaction(Reaction reaction, long reactionId);

    int cancelReaction(long reactionId);

}
