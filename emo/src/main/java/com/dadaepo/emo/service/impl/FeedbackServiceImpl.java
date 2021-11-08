package com.dadaepo.emo.service.impl;

import com.dadaepo.emo.dao.FeedbackDao;
import com.dadaepo.emo.dao.MemberDao;
import com.dadaepo.emo.dao.NoticeDao;
import com.dadaepo.emo.dto.feedback.ReactionRequest;
import com.dadaepo.emo.dto.feedback.ReactionResponse;
import com.dadaepo.emo.dto.member.Member;
import com.dadaepo.emo.dto.notice.NoticeRequest;
import com.dadaepo.emo.enums.NoticeType;
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

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public void addReaction(ReactionRequest reactionRequest) {
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());
        NoticeRequest noticeRequest = new NoticeRequest();

        reactionRequest.setSendId(member.getId());

        int insertReaction = feedbackDao.insertReaction(reactionRequest);
        if (insertReaction < 1) {
            log.error("리액션 등록에 실패하였습니다.");
        }

        long reactionId = reactionRequest.getId();

        int insertStatus = feedbackDao.insertReactionStatus(reactionId, reactionRequest);
        if (insertStatus != 1) {
            log.error("리액션 상태 등록에 실패하였습니다.");
        }

        noticeRequest.setSendId(reactionRequest.getSendId());
        noticeRequest.setReceiveId(reactionRequest.getReceiveId());
        noticeRequest.setType(NoticeType.REACTION);

        int insertNotice = noticeDao.insertNotice(noticeRequest);
        if (insertNotice != 1) {
            log.error("리액션 알림 보내기를 실패하였습니다.");
        }
    }

    @Override
    public ReactionResponse getReactions(long memoId) {
        ReactionResponse reactionResponse = new ReactionResponse();
        reactionResponse.setReactions(feedbackDao.selectReactions(memoId));

        return reactionResponse;
    }

    @Override
    public void updateReaction(ReactionRequest reactionRequest) {
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());
        reactionRequest.setSendId(member.getId());

        int updateReaction = feedbackDao.updateReaction(reactionRequest.getMemoId(), reactionRequest.getReaction(), reactionRequest.getSendId());
        if (updateReaction != 1) {
            log.error("리액션 수정에 실패하였습니다.");
        }
    }

    @Override
    public void deleteReaction(int memoId) {
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());

        int deleteReaction = feedbackDao.deleteReaction(memoId, member.getId());
        if (deleteReaction != 1) {
            log.error("리액션 삭제에 실패하였습니다.");
        }

        int updateStatus = feedbackDao.updateStatus(memoId, member.getId());
        if (updateStatus != 1) {
            log.error("리액션 상태 변경에 실패하였습니다.");
        }
    }

    @Override
    public int getReactionStatus(long memoId) {
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());

        return

                feedbackDao.selectReactionStatus(memoId, member.getId());
    }
}
