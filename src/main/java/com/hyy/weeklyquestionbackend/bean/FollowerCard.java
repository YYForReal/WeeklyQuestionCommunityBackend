package com.hyy.weeklyquestionbackend.bean;

import lombok.Data;

/**
 * @author bjyh
 * @version 1.0.0
 * @description: 在粉丝列表中的粉丝名片
 * @date 2022/3/21 9:17
 */
@Data
public class FollowerCard {
    private String username;
    private String avatar;
    private String description;
}
