package com.hyy.weeklyquestionbackend.service;

import com.hyy.weeklyquestionbackend.bean.FollowerCard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 获取粉丝列表
     *
     * @param userId
     * @return java.util.List<com.hyy.weeklyquestionbackend.bean.FollowerCard>
     * @author bjyh
     * @date 2022/3/21 9:20
     */
    List<FollowerCard> getFollowerList(@Param("userId") String userId);

    int checkFollowing(@Param("id1") String id1, @Param("id2") String id2);
}
