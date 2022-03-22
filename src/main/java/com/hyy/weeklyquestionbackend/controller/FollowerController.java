package com.hyy.weeklyquestionbackend.controller;

import com.hyy.weeklyquestionbackend.bean.FollowerCard;
import com.hyy.weeklyquestionbackend.service.impl.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String follow(String userId, String followerId) throws Exception {
        try {
            return followerService.follow(userId, followerId) == 1 ? "OK" : "Error";
        } catch (Exception e) {
            throw new Exception("关注失败");
        }
    }

    @PostMapping("/unfollow")
    public String unfollow(String userId, String followerId) {
        return followerService.unfollow(userId, followerId) == 1 ? "OK" : "Error";
    }

    @GetMapping("/getFollowerNumber")
    public Integer getFollowerNumber(String userId) {
        return followerService.getFollowerNumber(userId);
    }

    @GetMapping("/getFollowerList")
    public List<FollowerCard> getFollowerList(String userId) {
        return followerService.getFollowerList(userId);
    }

    @GetMapping("/checkFollowing")
    public Boolean checkFollowing(String id1, String id2) {
        return followerService.checkFollowing(id1, id2) == 1;
    }
}
