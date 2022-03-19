package com.hyy.weeklyquestionbackend.service;

import com.hyy.weeklyquestionbackend.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<String> getAllUserId();

    User getUserInfoById(@Param("userId") String userId);

    // return the number of inserted row
    int insertLoginInfo(@Param("userId") String userId, @Param("password") String password);

    int updateAvatarUrl(@Param("userId") String userId, @Param("avatar") String avatar);

    int updateBackground(@Param("userId") String userId, @Param("background") String background);

    int updateDescription(@Param("userId") String userId, @Param("description") String description);

    int updateEmail(@Param("userId") String userId, @Param("email") String email);

    int updateUserName(@Param("userId") String userId, @Param("userName") String userName);

    int updatePassword(@Param("userId") String userId, @Param("password") String password);
    /**
     * 获取用户的文章数量
     *
     * @param userId
     * @return int
     * @author bjyh
     * @date 2022/3/17 17:50
     */
    int getArticleNumber(@Param("userId") String userId);

    int getQuestionNumber(@Param("userId") String userId);

    int getChoiceNumber(@Param("userId") String userId);

}
