package com.dadaepo.emo.controller;

import com.dadaepo.emo.dto.notice.NoticeResponse;
import com.dadaepo.emo.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("알림 관리")
@RestController
@RequestMapping("/api/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @ApiOperation(value = "알림 받기")
    @GetMapping
    public ResponseEntity<NoticeResponse> getNotices(@RequestParam(value = "start", defaultValue = "0") int start) {
        return ResponseEntity.ok(noticeService.getNotices(start));
    }

    @ApiOperation(value = "알림 확인")
    @PutMapping("/{noticeId}")
    public ResponseEntity<Object> checkNotice(@PathVariable("noticeId") long noticeId) {
        noticeService.checkNotice(noticeId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
