package com.dadaepo.emo.controller;

import com.dadaepo.emo.dto.memo.EmotionRequest;
import com.dadaepo.emo.dto.memo.LineResponse;
import com.dadaepo.emo.dto.memo.MemoResponse;
import com.dadaepo.emo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emotion")
public class MemoController {

    @Autowired
    private MemoService memoService;

    @PostMapping()
    public ResponseEntity<Object> addMemo(@RequestBody EmotionRequest emotionRequest) {
        memoService.addMemo(emotionRequest);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/month")
    public ResponseEntity<MemoResponse> getMemoForMonth(@RequestParam(value = "yearMonth") String yearMonth) {
        return ResponseEntity.ok(memoService.getMemoForMonth(yearMonth));
    }

    @GetMapping("/feed")
    public ResponseEntity<LineResponse> getFeed(@RequestParam(value = "start", defaultValue = "0") int start) {
        return ResponseEntity.ok(memoService.getFeed(start));
    }
}
