package com.hyy.weeklyquestionbackend.controller;


import com.alibaba.fastjson.JSON;
import com.hyy.weeklyquestionbackend.bean.Article;
import com.hyy.weeklyquestionbackend.bean.Choice;
import com.hyy.weeklyquestionbackend.bean.HotArticle;
import com.hyy.weeklyquestionbackend.bean.PostArticleFrom;
import com.hyy.weeklyquestionbackend.service.impl.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    ArticleService articleService;

    //根据作者ID获取文章
    @GetMapping("/getArticlesFromAuthor")
    public List<Article> getArticlesFromAuthor(String authorId) {
        List<Article> list = articleService.getArticlesFromAuthor(authorId);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(JSON.toJSONString(list.get(i)));
        }
        return list;
    }

    //根据文章id获取文章
    @GetMapping("/getArticleFromId")
    public Article getArticlesFromId(Integer articleId) {
        Article article = articleService.getArticleFromId(articleId);
        return article;
    }

    //根据文章id修改文章
    @GetMapping("/update")
    public Article updateArticlesFromId(Integer articleId) {
        Article  article = articleService.getArticleFromId(articleId);
        return article;
    }


    //删除文章
    @PostMapping("/delete")
    public String deleteArticle(Integer articleId) {
        if (articleService.deleteArticle(articleId)) {
            return "OK";
        } else {
            return "fail";
        }
    }


    //拿所有的文章
    @GetMapping("/getAll")
    public List<Article> getArticles() {
        List<Article> list = articleService.getArticles();
        return list;
    }

    //获取热榜文章
    @GetMapping("/getHot")
    public List<HotArticle> getHotArticles() {
        List<HotArticle> list = articleService.getHotArticles();
        return list;
    }

//    //上传文章
//    @PostMapping("/postArticle")
//    public String postArticle(String title, String content, String authorId, Integer type, String tags, String img, @RequestParam(required = false) Choice dynamicItem[]) throws Exception {
//
//        if(type==1||type==0||type==2){
//            if(articleService.postArticle(title, content, authorId,type, tags,img)){//没有接连获取id，并发的时候会出现问题。
//                String articleId = articleService.getLastInsertId();
//                if(type==2){//普通文章放置成功，额外增设选择题文章
//                    System.out.println("查询选择题数据库");
//                    for(int i=0;i<dynamicItem.length;i++){
//                        System.out.println(dynamicItem[i].getContent());
//                    }
//                    System.out.println("not null");
//
//                    articleService.insertChoices(articleId,dynamicItem);
//                }
//                return articleId;
//            }else{
//                throw new Exception("error");
//            }
//        }else{
//            throw new Exception("文章类型错误");
//        }
//
//    }


    //    //上传文章
    @PostMapping("/postArticle")
    public String postArticle(@RequestBody PostArticleFrom postArticleFrom) throws Exception {
        System.out.println(postArticleFrom);
        Integer type = postArticleFrom.getType();
        String title = postArticleFrom.getTitle();
        String authorId = postArticleFrom.getAuthorId();
        String img = postArticleFrom.getImg();
        String tags = postArticleFrom.getTags();
        String content = postArticleFrom.getContent();
        List<Choice> dynamicItem = postArticleFrom.getDynamicItem();

        if (type == 1 || type == 0 || type == 2) {
            if (articleService.postArticle(title, content, authorId, type, tags, img)) {//没有接连获取id，并发的时候会出现问题。
                String articleId = articleService.getLastInsertId();
                if (type == 2) {//普通文章放置成功，额外增设选择题文章
                    System.out.println("查询选择题数据库");
                    articleService.insertChoices(articleId, postArticleFrom.getDynamicItem());
                }
                return articleId;
            } else {
                throw new Exception("error");
            }
        } else {
            throw new Exception("文章类型错误");
        }

    }


    //上传图片
    @PostMapping("/postImg")
    public String postImg(MultipartFile file) {

        return articleService.postImg(file);
    }


    //修改文章
    @PostMapping("/changeArticle")
    public String changeArticle(Integer articleId, String title, String content) {
        if (articleService.changeArticle(articleId, title, content)) {
            return "OK";
        } else {
            return "fail";
        }
    }






    //赞同文章
    @PostMapping("/agree")
    public String agreeArticle(Integer articleId, Integer agreeNumber) {
        if (articleService.agreeArticle(articleId, agreeNumber)) {
            return "OK";
        } else {
            return "fail";
        }
    }

}
