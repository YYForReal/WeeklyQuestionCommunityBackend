package com.hyy.weeklyquestionbackend.service.impl;

import com.hyy.weeklyquestionbackend.bean.FollowerCard;
import com.hyy.weeklyquestionbackend.service.FollowerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public int follow(String userId, String followerId) {
        return followerDao.follow(userId, followerId);
    }

    public int unfollow(String userId, String followerId) {
        return followerDao.unfollow(userId, followerId);
    }

    public Integer getFollowerNumber(String userId) {
        return followerDao.getFollowerNumber(userId);
    }

    public List<FollowerCard> getFollowerList(String userId) {
        return followerDao.getFollowerList(userId);
    }

    public int checkFollowing(String id1, String id2) {
        return followerDao.checkFollowing(id1, id2);
    }

}
