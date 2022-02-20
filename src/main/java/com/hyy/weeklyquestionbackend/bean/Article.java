package com.hyy.weeklyquestionbackend.bean;


import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * author:yy
 * time:2021.1
 * description: 文章的相关信息，包括利用authorId获取的用户信息
 */
@Data
public class Article {
    private Integer articleId;//文章id

    private String title;//文章标题

    private String content;//文章内容

    private String authorId;//作者

    private String authorName; //作者名字

    private String authorDescription;//作者简介

    private Date releaseTime;//文章创建时间

    private Date updateTime;//文章最后一次更新时间

    private Integer agree;//赞同数

    private Integer type;//类型：0 问答， 1 文章 ， 2. 选择题

    private String tags;//文章标签，逗号分隔

    private Integer showTimes;//文章展现次数

    private String img;//文章封面图片

    private List<Choice> choices;
}
