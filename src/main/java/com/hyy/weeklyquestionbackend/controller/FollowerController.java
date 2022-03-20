package com.hyy.weeklyquestionbackend.controller;

import com.hyy.weeklyquestionbackend.service.impl.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bjyh
 * @version 1.0.0
 * @description: 控制层，处理前端请求
 * @date 2022/3/20 16:16
 */
@RestController
@RequestMapping("/follower")
public class FollowerController {

    @Autowired
    FollowerService followerService;

    @PostMapping("/follow")
    public String follow(String userId, String followerId) {
        return followerService.follow(userId, followerId) == 1 ? "OK" : "Error";
    }

    @PostMapping("/unfollow")
    public String unfollow(String userId, String followerId) {
        return followerService.unfollow(userId, followerId) == 1 ? "OK" : "Error";
    }

    @GetMapping("/getFollowerNumber")
    public Integer getFollowerNumber(String userId) {
        return followerService.getFollowerNumber(userId);
    }
}
