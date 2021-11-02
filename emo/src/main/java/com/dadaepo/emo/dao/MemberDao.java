package com.dadaepo.emo.dao;

import com.dadaepo.emo.dto.Member;
import com.dadaepo.emo.dto.request.MemberSignupRequest;
import com.dadaepo.emo.dto.request.MemberUpdateRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDao {

    int insertMember(Member member);
    Member selectUserByUserId(String userId);
    List<String> selectUserAuthOneByUserId(String userId);
    int updateProfile(MemberUpdateRequest request);
}
