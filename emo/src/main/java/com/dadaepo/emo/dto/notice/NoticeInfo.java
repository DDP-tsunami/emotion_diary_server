package com.dadaepo.emo.dto.notice;

import com.dadaepo.emo.dto.member.MemberInfo;
import com.dadaepo.emo.enums.NoticeType;
import lombok.Data;

@Data
public class NoticeInfo {
    private long id;
    private NoticeType type;
    private long sendId;
    private MemberInfo sender;
    private boolean status;
    private String date;

}
