package com.hyy.weeklyquestionbackend.controller;

import com.hyy.weeklyquestionbackend.service.impl.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author bjyh
 * @version 1.0.0
 * @description: 控制层，处理前端请求
 * @date 2022/3/20 16:16
 */
@RestController
@RequestMapping("/follower")
@CrossOrigin
public class FollowerController {

    @Autowired
    FollowerService followerService;

    @PostMapping("/follow")
    public String follow(String userId, String followerId) throws Exception{
        try{
            return followerService.follow(userId, followerId) == 1 ? "OK" : "Error";
        }catch(Exception e){
            throw new Exception("关注失败");
        }
    }

    @PostMapping("/unfollow")
    public String unfollow(String userId, String followerId) {
        return followerService.unfollow(userId, followerId) == 1 ? "OK" : "Error";
    }

    @GetMapping("/s")
    public Integer getFollowerNumber(String userId) {
        return followerService.getFollowerNumber(userId);
    }
}
