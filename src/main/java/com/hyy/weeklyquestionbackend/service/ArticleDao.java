package com.hyy.weeklyquestionbackend.service;

//import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.hyy.weeklyquestionbackend.bean.Article;
import com.hyy.weeklyquestionbackend.bean.HotArticle;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {

    List<Article> getArticles();

    List<Article> getArticlesFromAuthor(@Param("authorId") String authorId);

    //   上传文章：标题，内容，作者，当前时间
    Integer postArticle(@Param("title") String title, @Param("content") String content,
                        @Param("authorId") String authorId, @Param("type") Integer type,
                        @Param("time") String time, @Param("tags") String tags);


    //   上传文章：标题，内容，作者，当前时间
    Integer postArticleWithImg(@Param("title") String title, @Param("content") String content,
                               @Param("authorId") String authorId, @Param("type") Integer type,
                               @Param("time") String time, @Param("tags") String tags, @Param("img") String img);


    Integer changeArticle(@Param("articleId") Integer articleId, @Param("title") String title,
                          @Param("content") String content, @Param("time") String time);

    Integer agreeArticle(@Param("articleId") Integer articleId, @Param("agreeNumber") Integer agreeNumber);

    Integer addShowTimes(@Param("articleId") Integer articleId);
    Article getArticlesFromId(@Param("articleId") Integer articleId);

    //获取热榜文章
    List<HotArticle> getHotArticles();

    String getLastInsertId();

    Integer deleteArticle(@Param("articleId") Integer articleId);
}
