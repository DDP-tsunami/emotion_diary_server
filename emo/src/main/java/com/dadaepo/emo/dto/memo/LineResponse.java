package com.dadaepo.emo.dto.memo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LineResponse {
    private List<Line> lines;
    private int totalCount;
}
