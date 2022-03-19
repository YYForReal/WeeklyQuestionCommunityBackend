package com.hyy.weeklyquestionbackend.service;

import com.hyy.weeklyquestionbackend.bean.Choice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChoiceDao {


    List<Choice> selectChoices(@Param("articleId") Integer articleId);

    void insertChoice(@Param("articleId") String articleId, @Param("content") String content, @Param("isCorrect") Boolean isCorrect);
}
