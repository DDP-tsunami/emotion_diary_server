package com.dadaepo.emo.service.impl;

import com.dadaepo.emo.dao.MemberDao;
import com.dadaepo.emo.dao.MemoDao;
import com.dadaepo.emo.dto.member.Member;
import com.dadaepo.emo.dto.memo.*;
import com.dadaepo.emo.service.MemoService;
import com.dadaepo.emo.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MemoServiceImpl implements MemoService {

    @Autowired
    private MemoDao memoDao;

    @Autowired
    private MemberDao memberDao;

    @Override
    public void addMemo(EmotionRequest emotionRequest) {
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());
        emotionRequest.setMemberId(member.getId());
        int insertMemo = memoDao.insertMemo(emotionRequest);
        if(insertMemo != 1) {
            log.error("감정 등록에 실패하였습니다.");
        }
    }

    @Override
    public MemoResponse getMemoForMonth(String yearMonth) {
        MemoResponse memoResponse = new MemoResponse();
        String split[] = yearMonth.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int nextYear = year;
        int nextMonth = month+1;
        if(nextMonth == 13) {
            nextYear++;
            nextMonth = 1;
        }
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());
        List<Memo> memoList = memoDao.selectMemoForMonth(year, nextYear, month, nextMonth ,member.getId());

        memoResponse.setMemoList(memoList);
        memoResponse.setTotalCount(memoList.size());

        return memoResponse;
    }

    @Override
    public LineResponse getFeed(int start) {
        LineResponse lineResponse = new LineResponse();
        Member member = memberDao.selectUserByUserId(SecurityUtil.getCurrentUsername());

        lineResponse.setLines(memoDao.selectFeed(start, FEED_LIMIT, member.getId()));
        lineResponse.setTotalCount(memoDao.countFeedByUserId(member.getId()));

        return lineResponse;
    }

    @Override
    public EmotionDetailResponse getEmotionDetail(long emotionId) {
        EmotionDetailResponse emotionDetailResponse = new EmotionDetailResponse();
        emotionDetailResponse.setDetail(memoDao.selectEmotionDetail(emotionId));

        return emotionDetailResponse;
    }

}
