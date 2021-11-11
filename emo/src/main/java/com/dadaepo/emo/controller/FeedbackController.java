package com.dadaepo.emo.controller;

import com.dadaepo.emo.dto.feedback.MyReactionResponse;
import com.dadaepo.emo.dto.feedback.ReactionRequest;
import com.dadaepo.emo.dto.feedback.ReactionResponse;
import com.dadaepo.emo.exception.BusinessException;
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
    public ResponseEntity<Object> addReaction(@RequestBody ReactionRequest reactionRequest) throws BusinessException {
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
    public ResponseEntity<Object> updateReaction(@RequestBody ReactionRequest reactionRequest) throws BusinessException{
        feedbackService.updateReaction(reactionRequest);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @ApiOperation("반응 취소")
    @DeleteMapping("/{reactionId}")
    public ResponseEntity<Object> deleteReaction(@PathVariable("reactionId") int reactionId) throws BusinessException{
        feedbackService.deleteReaction(reactionId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @ApiOperation(value = "내 반응 확인", notes = "null : 리액션 없음 / 객체 있으면 : ")
    @GetMapping(value = "/myReaction/{memoId}")
    public ResponseEntity<MyReactionResponse> getMyReactionStatus(@PathVariable("memoId") long memoId) {
        return ResponseEntity.ok(feedbackService.getMyReactionStatus(memoId));
    }
}
