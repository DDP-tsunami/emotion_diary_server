package com.dadaepo.emo.controller;

import com.dadaepo.emo.dto.feedback.ReactionRequest;
import com.dadaepo.emo.dto.feedback.ReactionResponse;
import com.dadaepo.emo.service.FeedbackService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/reaction")
@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @ApiOperation("반응 등록")
    @PostMapping
    public ResponseEntity<Object> addReaction(@RequestBody ReactionRequest reactionRequest) {
        feedbackService.addReaction(reactionRequest);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @ApiOperation("반응 목록 받아오기")
    @GetMapping("/{memoId}")
    public ResponseEntity<ReactionResponse> getReactions(@PathVariable("memoId") long memoId) {
        return ResponseEntity.ok(feedbackService.getReactions(memoId));
    }

    @ApiOperation("반응 수정 하기")
    @PutMapping()
    public ResponseEntity<Object> updateReaction(@RequestBody ReactionRequest reactionRequest) {
        feedbackService.updateReaction(reactionRequest);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @ApiOperation("반응 취소")
    @DeleteMapping("/{memoId}")
    public ResponseEntity<Object> deleteReaction(@PathVariable("memoId") int memoId) {
        feedbackService.deleteReaction(memoId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @ApiOperation(value = "반응 상태 확인", notes = "0 : 반응 한적 없음, 1 : 반응 상태, 2 : 반응 취소 상태")
    @GetMapping(value = "/status/{memoId}")
    public ResponseEntity<Object> getReactionStatus(@PathVariable("memoId") long memoId) {
        int status = feedbackService.getReactionStatus(memoId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
