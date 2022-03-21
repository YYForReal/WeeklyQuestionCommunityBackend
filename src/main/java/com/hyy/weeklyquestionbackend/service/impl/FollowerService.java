package com.hyy.weeklyquestionbackend.service.impl;

import com.hyy.weeklyquestionbackend.service.FollowerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bjyh
 * @version 1.0
 * @description: 业务层, 操作follower表
 * @date 2022/3/20 16:07
 */
@Service
public class FollowerService {

    @Autowired
    FollowerDao followerDao;

    public int follow(String userId, String followerId) throws Exception{
        try{
            return followerDao.follow(userId, followerId);
        }catch(Exception err){
            throw new Exception("关注失败");
        }
    }

    public int unfollow(String userId, String followerId) {
        return followerDao.unfollow(userId, followerId);
    }

    public Integer getFollowerNumber(String userId) {
        return followerDao.getFollowerNumber(userId);
    }
}
