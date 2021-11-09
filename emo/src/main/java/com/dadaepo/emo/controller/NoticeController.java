package com.dadaepo.emo.controller;

import com.dadaepo.emo.dto.notice.NoticeResponse;
import com.dadaepo.emo.enums.NoticeType;
import com.dadaepo.emo.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("알림 관리")
@RestController
@RequestMapping("/api/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @ApiOperation(value = "알림 받기")
    @GetMapping
    public ResponseEntity<NoticeResponse> getNotices(@RequestParam(value = "start", defaultValue = "0") int start,
                                                     @RequestParam("noticeType")NoticeType noticeType) {
        return ResponseEntity.ok(noticeService.getNotices(start, noticeType));
    }

}
