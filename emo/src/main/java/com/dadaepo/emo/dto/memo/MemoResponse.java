package com.dadaepo.emo.dto.memo;

import com.dadaepo.emo.enums.Emotion;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemoResponse {
    private List<Memo> memoList;
    private int totalCount;
}
