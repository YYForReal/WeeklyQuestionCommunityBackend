package com.hyy.weeklyquestionbackend.service.impl;

import com.hyy.weeklyquestionbackend.bean.Article;
import com.hyy.weeklyquestionbackend.bean.Choice;
import com.hyy.weeklyquestionbackend.bean.HotArticle;
import com.hyy.weeklyquestionbackend.bean.qiniu.QiNiuYunConfig;
import com.hyy.weeklyquestionbackend.service.ArticleDao;
import com.hyy.weeklyquestionbackend.service.ChoiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * author:yy
 * description:文章管理的服务层
 */
@Service
public class ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Autowired
    QiNiuYunConfig qiNiuYunConfig;

//    @Autowired
//    ChoiceMapper choiceMapper;

    @Autowired
    ChoiceDao choiceDao;


    //    获取单个用户的所有文章
    public List<Article> getArticlesFromAuthor(String authorId) {
        List<Article> list = articleDao.getArticlesFromAuthor(authorId);
        for (int i = 0; i < list.size(); i++) {
            addShowTimes(list.get(i).getArticleId());
        }
        return list;
    }

//    获取所有文章
//    public List<Map<String,Object>> getArticles2(){
//        return articleDao.getArticles();
//    }

    public List<Article> getArticles() {
        List<Article> list = articleDao.getArticles();
        for (int i = 0; i < list.size(); i++) {
            addShowTimes(list.get(i).getArticleId());
        }
        return list;
    }

    /**
     * description: 上传文章
     *
     * @param title
     * @param content
     * @param authorId
     * @return boolean
     */
    public boolean postArticle(String title, String content, String authorId, Integer type, String tags, String img) {
        Date date = new Date();
//      获取当前系统时间和日期并格式化输出:
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dateTime = df.format(date); // Formats a Date into a date/time string.
        System.out.println(dateTime);  // 2017-09-24 23:33:20
        if (img == null || img.equals("")) {
            if (articleDao.postArticle(title, content, authorId, type, dateTime, tags) == 1) {
                System.out.println("上传不带封面的文章");
                return true;
            }
        } else if (articleDao.postArticleWithImg(title, content, authorId, type, dateTime, tags, img) == 1) {
            System.out.println("上传带封面文章");
            return true;
        }
        return false;
    }

    public String getLastInsertId() {
        return articleDao.getLastInsertId();
    }

    /**
     * description: 修改文章
     *
     * @param articleId
     * @param title
     * @param content
     * @return
     */
    public boolean changeArticle(Integer articleId, String title, String content) {
        Date date = new Date();
//      获取当前系统时间和日期并格式化输出:
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dateTime = df.format(date); // Formats a Date into a date/time string.
        System.out.println(dateTime);  // 2017-09-24 23:33:20

        if (articleDao.changeArticle(articleId, title, content, dateTime) == 1) {
            return true;
        }
        return false;
    }

    /**
     * @param articleId
     * @param agreeNumber
     * @return
     */
    public boolean agreeArticle(Integer articleId, Integer agreeNumber) {
        if (articleDao.agreeArticle(articleId, agreeNumber) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public Article getArticleFromId(Integer articleId) {
        Article article = articleDao.getArticlesFromId(articleId);
        addShowTimes(articleId);
        if (article.getType() == 2) {
            article.setChoices(choiceDao.selectChoices(articleId));
            System.out.println(article.getChoices());
        }
        return article;
    }

    public List<HotArticle> getHotArticles() {
        List<HotArticle> list = articleDao.getHotArticles();
        for (int i = 0; i < list.size(); i++) {
            addShowTimes(list.get(i).getArticleId());
        }

        return list;

    }

    public void addShowTimes(Integer articleId) {
        articleDao.addShowTimes(articleId);
    }

    public String postImg(MultipartFile file) {
        try {
            byte[] imgBytes = file.getBytes();
            Date date = new Date();
            String fileName = "commnunity/" + file.getName() + date.getTime();
            return qiNiuYunConfig.put64image(imgBytes, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void insertChoices(String articleId, List<Choice> dynamicItem) {
        try {
            for (int i = 0; i < dynamicItem.size(); i++) {
                dynamicItem.get(i).setArticleId(articleId);
                System.out.println("Insert Choice :" + dynamicItem.get(i).getArticleId() + "-" + dynamicItem.get(i).getContent() + "-" + dynamicItem.get(i).getIsCorrect());
                choiceDao.insertChoice(dynamicItem.get(i).getArticleId(), dynamicItem.get(i).getContent(), dynamicItem.get(i).getIsCorrect());
            }
        } catch (Exception e) {
            System.out.println("error in insertChoices" + e);
        }
    }
}
