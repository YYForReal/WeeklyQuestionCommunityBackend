package com.hyy.weeklyquestionbackend.service;


import com.hyy.weeklyquestionbackend.bean.Answer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerDao {

    List<Answer> getAnswersByArticle(@Param("articleId") Integer articleId);

    Integer agreeAnswer(@Param("answerId") Integer answerId, @Param("agreeNumber") Integer agreeNumber);

    Integer postAnswer(@Param("authorId") String authorId, @Param("articleId") Integer articleId,
                       @Param("content") String content, @Param("releaseTime") String dateTime);

    void addShowTimes(@Param("answerId") Integer answerId);
}
