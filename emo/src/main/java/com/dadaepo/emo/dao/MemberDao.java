package com.dadaepo.emo.dao;

import com.dadaepo.emo.dto.member.Member;
import com.dadaepo.emo.dto.member.MemberInfo;
import com.dadaepo.emo.dto.member.MemberUpdateRequest;
import com.dadaepo.emo.enums.NoticeType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDao {

    int insertMember(Member member);
    Member selectUserByUserId(String userId);
    String selectUserEmail(String email);
    String selectUserId(String userId);

    List<String> selectUserAuthOneByUserId(String userId);
    int updateProfile(MemberUpdateRequest request, @Param(value = "userId") String userId);
    MemberInfo selectUserByMemberId(long memberId);
    List<MemberInfo> selectUsersByEmail(String email, long memberId, NoticeType noticeType);

}
