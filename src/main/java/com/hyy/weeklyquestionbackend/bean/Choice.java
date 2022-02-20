package com.hyy.weeklyquestionbackend.bean;

import lombok.Data;

@Data
public class Choice {
    private String choiceId;
    private String articleId;
    private String content;//选择题内容
    private Boolean isCorrect;//选择题正确性
}
