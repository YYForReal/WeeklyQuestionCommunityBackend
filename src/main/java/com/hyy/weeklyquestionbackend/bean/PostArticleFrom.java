package com.hyy.weeklyquestionbackend.bean;

import lombok.Data;

import java.util.List;

@Data
public class PostArticleFrom {
    private String title;
    private String content;
    private String authorId;
    private Integer type;
    private String img;
    private String tags;
    private List<Choice> dynamicItem;
}
