package com.hyy.weeklyquestionbackend.service.impl;

import com.hyy.weeklyquestionbackend.bean.User;
import com.hyy.weeklyquestionbackend.bean.UserCard;
import com.hyy.weeklyquestionbackend.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<String> getAllUserId() {
        return userDao.getAllUserId();
    }


    public User getUserInfoById(String userId) {
        return userDao.getUserInfoById(userId);
    }


    public boolean insertLoginInfo(String userId, String password) {
        return userDao.insertLoginInfo(userId, password) == 1;
    }


    public boolean updateAvatarUrl(String userId, String avatar) {
        return userDao.updateAvatarUrl(userId, avatar) == 1;
    }


    public boolean updateBackground(String userId, String background) {
        return userDao.updateBackground(userId, background) == 1;
    }


    public boolean updateDescription(String userId, String description) {
        return userDao.updateDescription(userId, description) == 1;
    }


    public boolean updateEmail(String userId, String email) {
        return userDao.updateEmail(userId, email) == 1;
    }


    public boolean updateUserName(String userId, String userName) {
        return userDao.updateUserName(userId, userName) == 1;
    }


    public boolean updatePassword(String userId, String password) {
        return userDao.updatePassword(userId, password) == 1;
    }


    public int getArticleNumber(String userId) {
        return userDao.getArticleNumber(userId);
    }


    public int getAnswerNumber(String userId) {
        return userDao.getAnswerNumber(userId);
    }


    public int getChoiceNumber(String userId) {
        return userDao.getChoiceNumber(userId);
    }

    /**
     * 获取用户悬浮卡片信息
     *
     * @param userId
     * @return com.hyy.weeklyquestionbackend.bean.UserCard
     * @author bjyh
     * @date 2022/3/19 7:53
     */
    public UserCard getUserCardInfo(String userId) {
        UserCard userCard = new UserCard();
        userCard.setArticleNum(getArticleNumber(userId));
        userCard.setAnswerNum(getAnswerNumber(userId));
        userCard.setChoiceNum(getChoiceNumber(userId));
        return userCard;
    }
}
