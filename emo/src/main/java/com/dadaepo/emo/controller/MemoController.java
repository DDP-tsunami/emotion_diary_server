package com.dadaepo.emo.controller;

import com.dadaepo.emo.dto.memo.*;
import com.dadaepo.emo.exception.BusinessException;
import com.dadaepo.emo.service.MemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("감정 관리")
@RestController
@RequestMapping("/api/emotion")
public class MemoController {

    @Autowired
    private MemoService memoService;

    @ApiOperation(value = "감정 등록")
    @PostMapping()
    public ResponseEntity<Object> addMemo(@RequestBody EmotionRequest emotionRequest) throws BusinessException {
        memoService.addMemo(emotionRequest);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @ApiOperation(value = "한달간 감정 얻기")
    @GetMapping("/month")
    public ResponseEntity<MemoResponse> getMemoForMonth(@RequestParam(value = "yearMonth") String yearMonth) {
        return ResponseEntity.ok(memoService.getMemoForMonth(yearMonth));
    }

    @ApiOperation(value = "피드 보기")
    @GetMapping("/feed")
    public ResponseEntity<LineResponse> getFeed(@RequestParam(value = "start", defaultValue = "0") int start) {
        return ResponseEntity.ok(memoService.getFeed(start));
    }

    @ApiOperation(value = "디테일 받아오기")
    @GetMapping("/detail/{emotionId}")
    public ResponseEntity<EmotionDetailResponse> getEmotionDetail(@PathVariable("emotionId") long emotionId) {
        return ResponseEntity.ok(memoService.getEmotionDetail(emotionId));
    }

    @ApiOperation(value = "오늘 등록된 감정 받아오기")
    @GetMapping("/today")
    public ResponseEntity<MemoResponse> getEmotionToday() {
        return ResponseEntity.ok(memoService.getEmotionToday());
    }
}
