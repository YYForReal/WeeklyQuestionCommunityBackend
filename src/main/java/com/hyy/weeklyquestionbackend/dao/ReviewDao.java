package com.hyy.weeklyquestionbackend.dao;

import com.hyy.weeklyquestionbackend.bean.Review;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ReviewDao {

//    List<Review> getReviews(@Param("answerId") Integer answerId);

    List<Review> getReviews(@Param("type") Integer type,@Param("articleId") Integer articleId);

    Integer agreeReview(@Param("reviewId") Integer reviewId, @Param("agreeNumber") Integer agreeNumber);

    Integer postReview(@Param("articleId") Integer articleId, @Param("userId") String userId,
                       @Param("content") String content, @Param("type") Integer type,
                       @Param("releaseTime") String releaseTime);
}
