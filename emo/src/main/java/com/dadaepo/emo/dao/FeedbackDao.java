package com.dadaepo.emo.dao;

import com.dadaepo.emo.dto.feedback.ReactionInfo;
import com.dadaepo.emo.enums.Reaction;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackDao {
    int insertReaction(@Param("sendId") long sendId,@Param("memoId") long memoId, @Param("reaction") Reaction reaction);

    List<ReactionInfo> selectReactions(long memoId);

    List<Integer> selectCountReactionByType(long memoId);
}
