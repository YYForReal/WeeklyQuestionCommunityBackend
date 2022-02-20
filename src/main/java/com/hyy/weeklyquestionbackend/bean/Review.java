package com.hyy.weeklyquestionbackend.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Review {
    private Integer reviewId;//评论id

    private String content;//评论内容

    private String userId;//评论作者

    private String userName;//作者名字

    private String userAvatar;//作者头像

    private Date releaseTime;//评论创建时间

    private Integer agree;//赞同数

}
