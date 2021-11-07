package com.dadaepo.emo.dto.member;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberInfoResponse {
    private List<MemberInfo> memberInfoList;
}
