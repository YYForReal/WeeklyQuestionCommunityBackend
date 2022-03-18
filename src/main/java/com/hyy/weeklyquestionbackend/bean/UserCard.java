package com.hyy.weeklyquestionbackend.bean;

import lombok.Data;

/**
 * @author bjyh
 * @version 1.0
 * @description: 用户悬浮卡片，显示文章/回答/选择的信息
 * @date 2022/3/19 7:45
 */
@Data
public class UserCard {
    private Integer answerNum;
    private Integer articleNum;
    private Integer choiceNum;
}
