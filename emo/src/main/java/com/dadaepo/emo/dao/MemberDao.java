package com.dadaepo.emo.dao;

import com.dadaepo.emo.dto.member.Member;
import com.dadaepo.emo.dto.member.MemberUpdateRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDao {

    int insertMember(Member member);
    Member selectUserByUserId(String userId);
    List<String> selectUserAuthOneByUserId(String userId);
    int updateProfile(MemberUpdateRequest request, @Param(value = "userId") String userId);
}
