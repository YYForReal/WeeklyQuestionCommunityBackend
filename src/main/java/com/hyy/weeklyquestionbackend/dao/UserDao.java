package com.hyy.weeklyquestionbackend.dao;

import com.hyy.weeklyquestionbackend.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserDao {
    public Set<String> getAllUserId();

    public User getUserInfoById(@Param("userId") String userId);

    // return the number of inserted row
    public int insertLoginInfo(@Param("userId") String userId, @Param("password") String password);

    public int updateAvatarUrl(@Param("userId") String userId, @Param("avatar") String avatar);

    public int updateBackground(@Param("userId") String userId, @Param("background") String background);

    public int updateDescription(@Param("userId") String userId, @Param("description") String description);

    public int updatetEmail(@Param("userId") String userId, @Param("email") String email);

    public int updateUserName(@Param("userId") String userId, @Param("userName") String userName);

    public int updatePassword(@Param("userId") String userId, @Param("password") String password);

    public String token(@Param("userId") String userId, @Param("password") String password);
}
