package com.dadaepo.emo.dto.notice;

import com.dadaepo.emo.dto.notice.Notice;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NoticeResponse {
    private List<NoticeInfo> notices;
    private int totalCount;
}
