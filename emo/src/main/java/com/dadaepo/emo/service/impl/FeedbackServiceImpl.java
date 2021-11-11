package com.dadaepo.emo.service.impl;

import com.dadaepo.emo.dao.FeedbackDao;
import com.dadaepo.emo.dao.MemberDao;
import com.dadaepo.emo.dao.NoticeDao;
import com.dadaepo.emo.dto.feedback.MyReactionResponse;
import com.dadaepo.emo.dto.feedback.ReactionRequest;
import com.dadaepo.emo.dto.feedback.ReactionResponse;
import com.dadaepo.emo.dto.member.Member;
import com.dadaepo.emo.dto.notice.NoticeRequest;
import com.dadaepo.emo.enums.NoticeType;
import com.dadaepo.emo.exception.BusinessException;
import com.dadaepo.emo.exception.feedback.ReactionDuplication;
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
    public void addReaction(ReactionRequest reactionRequest) throws BusinessException {

        MyReactionResponse myReactionResponse = getMyReactionStatus(reactionRequest.getMemoId());
        if(myReactionResponse != null) {
            log.error("이미 리액션이 등록되어 있습니다.");
            throw new ReactionDuplication();
        }

        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());
        NoticeRequest noticeRequest = new NoticeRequest();

        reactionRequest.setSendId(member.getId());

        int insertReaction = feedbackDao.insertReaction(reactionRequest);
        if (insertReaction != 1) {
            log.error("리액션 등록에 실패하였습니다.");
            throw new BusinessException();
        }

        noticeRequest.setSendId(reactionRequest.getSendId());
        noticeRequest.setReceiveId(reactionRequest.getReceiveId());
        noticeRequest.setType(NoticeType.REACTION);

        int insertNotice = noticeDao.insertReactionNotice(noticeRequest, reactionRequest.getReactionId());
        if (insertNotice != 1) {
            log.error("리액션 알림 보내기를 실패하였습니다.");
            throw new BusinessException();
        }
    }

    @Override
    public ReactionResponse getReactions(long memoId) {
        ReactionResponse reactionResponse = new ReactionResponse();
        reactionResponse.setReactions(feedbackDao.selectReactions(memoId));

        return reactionResponse;
    }

    @Override
    public void updateReaction(ReactionRequest reactionRequest) throws BusinessException{
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());
        NoticeRequest noticeRequest = new NoticeRequest();

        int deleteReactionNotice = noticeDao.deleteReactionNotice(reactionRequest.getReactionId());
        if (deleteReactionNotice != 1) {
            log.error("리액션 알림 삭제에 실패하였습니다.");
            throw new BusinessException();
        }

        int updateReaction = feedbackDao.updateReaction(reactionRequest.getReaction(), reactionRequest.getReactionId());
        if (updateReaction != 1) {
            log.error("리액션 수정에 실패하였습니다.");
            throw new BusinessException();
        }

        noticeRequest.setSendId(member.getId());
        noticeRequest.setReceiveId(reactionRequest.getReceiveId());
        noticeRequest.setType(NoticeType.REACTION);

        int insertReactionNotice = noticeDao.insertReactionNotice(noticeRequest, reactionRequest.getReactionId());
        if (insertReactionNotice != 1) {
            log.error("리액션 알림 등록에 실패하였습니다.");
            throw new BusinessException();
        }
    }

    @Override
    public void deleteReaction(long reactionId) throws BusinessException {
        int deleteReactionNotice = noticeDao.deleteReactionNotice(reactionId);
        if (deleteReactionNotice != 1) {
            log.error("리액션 알림 삭제에 실패하였습니다.");
            throw new BusinessException();
        }

        int cancelReaction = feedbackDao.cancelReaction(reactionId);
        if (cancelReaction != 1) {
            log.error("리액션 취소에 실패하였습니다.");
            throw new BusinessException();
        }
    }

    @Override
    public MyReactionResponse getMyReactionStatus(long memoId) {
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());
        return feedbackDao.selectMyReactionStatus(memoId, member.getId());
    }
}
