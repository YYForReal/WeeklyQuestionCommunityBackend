package com.hyy.weeklyquestionbackend.controller;

import com.hyy.weeklyquestionbackend.bean.Answer;
import com.hyy.weeklyquestionbackend.service.impl.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
@CrossOrigin
public class AnswerController {

    @Autowired
    AnswerService answerService;

    //根据问题id获取对应的回答
    @GetMapping("/getAnswers")
    public List<Answer> getAnswers(Integer articleId) {
//        System.out.println("articleId :" + articleId);
        List<Answer> list = answerService.getAnswers(articleId);
        return list;
    }

    //赞同文章
    @PostMapping("/agree")
    public String agreeArticle(Integer answerId, Integer agreeNumber) {
        if (answerService.agreeAnswer(answerId, agreeNumber)) {
            return "OK";
        } else {
            return "fail";
        }
    }

    //上传文章
    @PostMapping("/postAnswer")
    public String postAnswer(String authorId, Integer articleId, String content) {
        if (answerService.postAnswer(authorId, articleId, content)) {
            return "OK";
        } else {
            return "fail";
        }
    }


}

