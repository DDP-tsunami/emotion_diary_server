package com.dadaepo.emo.controller;

import com.dadaepo.emo.dto.friend.Friend;
import com.dadaepo.emo.dto.friend.FriendRequest;
import com.dadaepo.emo.dto.friend.FriendResponse;
import com.dadaepo.emo.dto.notice.NoticeRequest;
import com.dadaepo.emo.service.FriendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("친구 관리")
@RestController
@RequestMapping("/api/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @ApiOperation(value = "친구 요청")
    @PostMapping("/request")
    public ResponseEntity<Object> sendFriendNotice(@RequestBody NoticeRequest noticeRequest) {
        friendService.sendFriendNotice(noticeRequest);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @ApiOperation(value = "친구 수락")
    @PostMapping("/acceptance")
    public ResponseEntity<Object> acceptFriend(@RequestBody FriendRequest friendRequest) {
        friendService.acceptFriend(friendRequest);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @ApiOperation(value = "친구 목록 받기")
    @GetMapping("")
    public ResponseEntity<FriendResponse> getFriends() {
        return ResponseEntity.ok(friendService.getFriends());
    }

    @ApiOperation(value = "친구 삭제")
    @DeleteMapping("/{memberId}")
    public ResponseEntity<Object> deleteFriend(@PathVariable("memberId") long memberId) {
        friendService.deleteFriend(memberId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
