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
}