package com.hyy.weeklyquestionbackend.service;

import com.hyy.weeklyquestionbackend.bean.Review;
import com.hyy.weeklyquestionbackend.dao.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewDao reviewDao;

    public List<Review> getReviews(Integer type,Integer articleId) {
        return reviewDao.getReviews(type,articleId);
    }

    public boolean agreeReview(Integer reviewId, Integer agreeNumber) {
        if(reviewDao.agreeReview(reviewId,agreeNumber) == 1){
            return true;
        }else{
            return false;
        }
    }

    public boolean postReview(Integer articleId, String userId, String content, Integer type) {
        Date date = new Date();
//      获取当前系统时间和日期并格式化输出:
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dateTime = df.format(date); // Formats a Date into a date/time string.
        System.out.println("post review at : "+ dateTime);  // 2017-09-24 23:33:20

        if(reviewDao.postReview(articleId,userId,content,type,dateTime) == 1){
            return true;
        }else{
            return false;
        }
    }

//    public List<Review> getReviewsFromAnswer(Integer answerId) {
//        return reviewDao.getReviewsFromAnswer(answerId);
//    }
}
