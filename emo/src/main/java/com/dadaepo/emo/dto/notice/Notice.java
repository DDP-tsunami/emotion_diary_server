package com.dadaepo.emo.dto.notice;

import com.dadaepo.emo.enums.NoticeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notice {
    private long id;
    private NoticeType type;
    private long receiveId;
    private long sendId;
    private boolean status;
    private String date;
}
