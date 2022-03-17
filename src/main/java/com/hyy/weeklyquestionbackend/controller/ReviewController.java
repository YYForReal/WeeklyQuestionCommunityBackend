package com.hyy.weeklyquestionbackend.controller;


import com.alibaba.fastjson.JSON;
import com.hyy.weeklyquestionbackend.bean.Review;
import com.hyy.weeklyquestionbackend.service.impl.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@CrossOrigin
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    //根据类型 与 id获取评论
    @GetMapping("/getReviews")
    public List<Review> getReviews(Integer type, Integer articleId) {
        System.out.println("获取类型为：" + type + "，articleId为：" + articleId + "的评论");
        List<Review> list = reviewService.getReviews(type, articleId);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(JSON.toJSONString(list.get(i)));
        }
        return list;
    }

    //赞同评论
    @PostMapping("/agree")
    public String agreeArticle(Integer reviewId, Integer agreeNumber) {
        if (reviewService.agreeReview(reviewId, agreeNumber)) {
            return "OK";
        } else {
            return "fail";
        }
    }

    @PostMapping("/post")
    public String postReview(Integer articleId, String userId, String content, Integer type) {
        if (reviewService.postReview(articleId, userId, content, type)) {
            return "OK";
        } else {
            return "fail";
        }
    }


}
