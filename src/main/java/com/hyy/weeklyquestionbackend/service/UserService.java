package com.hyy.weeklyquestionbackend.service;

import com.hyy.weeklyquestionbackend.bean.User;
import com.hyy.weeklyquestionbackend.dao.UserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Set;

@Service
public class UserService {

    @Resource
    UserDao userDao;

    public Set<String> getAllUserId() {
        return userDao.getAllUserId();
    }

    // get user's info
    public User getUserInfoById(String userId) {
        return userDao.getUserInfoById(userId);
    }

    // insert user's login info
    public boolean insertLoginInfo(String userId, String password) {
        return userDao.insertLoginInfo(userId, password) == 1;
    }

    // update avatar url
    public boolean updateAvatarUrl(String userId, String avatar) {
        return userDao.updateAvatarUrl(userId, avatar) == 1;
    }

    // update email
    public boolean updateEmail(String userId, String email) {
        return userDao.updatetEmail(userId, email) == 1;
    }

    // update password
    public boolean updatePassword(String userId, String password) {
        return userDao.updatePassword(userId, password) == 1;
    }

    public boolean updateDescription(String userId, String description) {
        return userDao.updateDescription(userId, description) == 1;

    }

    public boolean updateUserName(String userId, String userName) {
        return userDao.updateUserName(userId, userName) == 1;
    }

    public boolean updateBackground(@Param("userId") String userId, @Param("background") String background) {
        return userDao.updateBackground(userId, background) == 1;
    }

    public boolean token(@Param("userId") String userId, @Param("password") String password) {
        return Objects.equals(userDao.token(userId, password), "true");
    }

}
