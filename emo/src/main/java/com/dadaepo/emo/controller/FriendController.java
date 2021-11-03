package com.dadaepo.emo.controller;

import com.dadaepo.emo.dto.friend.Friend;
import com.dadaepo.emo.dto.friend.FriendRequest;
import com.dadaepo.emo.dto.friend.FriendResponse;
import com.dadaepo.emo.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @PostMapping("")
    public ResponseEntity<Object> acceptFriend(@RequestBody FriendRequest friendRequest) {
        friendService.acceptFriend(friendRequest);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<FriendResponse> getFriends() {
        return ResponseEntity.ok(friendService.getFriends());
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Object> deleteFriend(@PathVariable("memberId") long memberId) {
        friendService.deleteFriend(memberId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
