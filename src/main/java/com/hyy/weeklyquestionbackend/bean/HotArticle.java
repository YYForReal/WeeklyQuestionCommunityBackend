package com.hyy.weeklyquestionbackend.bean;

import lombok.Data;

import java.util.Date;

/**
 * author:yy
 * time:2021.1.5
 * description: 返回热榜封面文章,减少请求携带数据
 */
@Data
public class HotArticle {
    private Integer articleId;//文章id

    private String title;//文章标题

    private String content;//文章内容

    private Integer hot;//热度 = 赞同数*10 + 查看次数 + ...

    private String img;//文章封面图片
}
