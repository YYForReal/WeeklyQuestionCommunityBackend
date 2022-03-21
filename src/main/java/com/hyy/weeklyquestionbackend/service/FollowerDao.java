package com.hyy.weeklyquestionbackend.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author bjyh
 * @version 1.0
 * @description: 访问follower表数据的对象
 * @date 2022/3/20 14:45
 */
@Repository
public interface FollowerDao {
    /**
     * 用户名为userId的用户新增一个粉丝，粉丝ID为followerId
     *
     * @param userId
     * @param followerId
     * @return int
     * @author bjyh
     * @date 2022/3/20 14:50
     */
    int follow(@Param("userId") String userId, @Param("followerId") String followerId);

    int unfollow(@Param("userId") String userId, @Param("followerId") String followerId);

    /**
     * 获取userId用户的粉丝数
     *
     * @param userId
     * @return int
     * @author bjyh
     * @date 2022/3/20 16:45
     */
    Integer getFollowerNumber(@Param("userId") String userId);
}
