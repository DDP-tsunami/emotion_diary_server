package com.dadaepo.emo.dao;

import com.dadaepo.emo.dto.feedback.ReactionInfo;
import com.dadaepo.emo.dto.feedback.ReactionRequest;
import com.dadaepo.emo.enums.Reaction;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackDao {
    int insertReaction(ReactionRequest reactionRequest);

    List<ReactionInfo> selectReactions(long memoId);

    List<Integer> selectCountReactionByType(long memoId);

    int insertReactionStatus(long reactionId, ReactionRequest reactionRequest);

    int updateReaction(long memoId, Reaction reaction, long sendId);

    int updateStatus(long memoId, long sendId);

    int deleteReaction(long memoId, long sendId);

    int selectReactionStatus(long memoId, long sendId);
}
