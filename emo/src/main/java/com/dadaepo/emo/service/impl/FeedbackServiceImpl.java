package com.dadaepo.emo.service.impl;

import com.dadaepo.emo.dao.FeedbackDao;
import com.dadaepo.emo.dao.MemberDao;
import com.dadaepo.emo.dto.feedback.ReactionRequest;
import com.dadaepo.emo.dto.feedback.ReactionResponse;
import com.dadaepo.emo.dto.member.Member;
import com.dadaepo.emo.service.FeedbackService;
import com.dadaepo.emo.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    @Autowired
    private MemberDao memberDao;

    @Override
    public void addReaction(ReactionRequest reactionRequest) {
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());
        reactionRequest.setMemberId(member.getId());

        int insertReaction = feedbackDao.insertReaction(reactionRequest);
    }

    @Override
    public ReactionResponse getReactions(long memoId) {
        ReactionResponse reactionResponse = new ReactionResponse();
        reactionResponse.setReactions(feedbackDao.selectReactions(memoId));

        return reactionResponse;
    }
}
