package com.dadaepo.emo.service.impl;

import com.dadaepo.emo.dao.MemberDao;
import com.dadaepo.emo.dto.Member;
import com.dadaepo.emo.dto.UserDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberDao memberDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String inputUserId) {

        UserDetailsVO userDetails = new UserDetailsVO();
        Member member = memberDao.selectUserByUserId(inputUserId);
        // 사용자 정보 없으면 null 처리
        if(member == null) {
            throw new UsernameNotFoundException(inputUserId + " -> 데이터베이스에서 찾을 수 없습니다.");
        // 사용자 정보 있을 경우 로직 전개 (userDetails에 데이터 넣기)
        } else {
            userDetails.setUsername(member.getUserId());
            userDetails.setPassword(member.getPassword());

            userDetails.setAuthorities(memberDao.selectUserAuthOneByUserId(inputUserId));
        }
        return userDetails;
    }
}
