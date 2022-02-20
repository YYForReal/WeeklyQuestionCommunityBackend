package com.hyy.weeklyquestionbackend.service;

import com.hyy.weeklyquestionbackend.bean.Answer;
import com.hyy.weeklyquestionbackend.dao.AnswerDao;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    AnswerDao answerDao;

    public List<Answer> getAnswers(Integer articleId) {
        List<Answer> list = answerDao.getAnswersByArticle(articleId);
        for(int i=0;i<list.size();i++){
            addShowTimes(list.get(i).getAnswerId());
        }
        return list;
    }

    public boolean agreeAnswer(Integer answerId, Integer agreeNumber) {
        if(answerDao.agreeAnswer(answerId,agreeNumber) == 1){
            return true;
        }else{
            return false;
        }
    }

    public boolean postAnswer(String authorId, Integer articleId, String content) {
        Date date = new Date();
//      获取当前系统时间和日期并格式化输出:
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dateTime = df.format(date); // Formats a Date into a date/time string.
        System.out.println(dateTime);  // 2017-09-24 23:33:20

        if(answerDao.postAnswer(authorId,articleId,content,dateTime) == 1){
            return true;
        }
        return false;
    }
//    增加查看次数
    public void addShowTimes(Integer answerId){
        answerDao.addShowTimes(answerId);
    }

}
