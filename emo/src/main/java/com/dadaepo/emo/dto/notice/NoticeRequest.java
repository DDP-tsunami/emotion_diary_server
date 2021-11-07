package com.dadaepo.emo.dto.notice;

import com.dadaepo.emo.enums.NoticeType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeRequest {
    private long sendId;
    private long receiveId;
    private NoticeType type;
}
