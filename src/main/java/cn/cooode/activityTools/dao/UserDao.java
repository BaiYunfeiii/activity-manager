package cn.cooode.activityTools.dao;

import cn.cooode.activityTools.entity.User;

/**
 * Created by BaiYunfei on 2017/1/3.
 */
public interface UserDao extends BaseDao<User> {
    public User getByUsername(String username);
}
