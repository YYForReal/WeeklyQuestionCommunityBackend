package com.hyy.weeklyquestionbackend.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author bjyh
 * @version 1.0
 * @description: many-to-many relationship
 * @date 2022/3/20 14:41
 */
@Data
public class Follower {
    private String userId;
    private String followerId;
    private Date followedDate;
    private Date unfollowedDate;
}
