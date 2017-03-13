package cn.cooode.activityTools.dao.impl;

import cn.cooode.activityTools.dao.UserDao;
import cn.cooode.activityTools.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by BaiYunfei on 2017/1/3.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
    public User getByUsername(String username) {
        String hql = "from User u where u.username= :username";
        Map<String,Object> alias = new HashMap<String, Object>();
        alias.put("username",username);
        return (User)queryObject(hql,alias);
    }
}
