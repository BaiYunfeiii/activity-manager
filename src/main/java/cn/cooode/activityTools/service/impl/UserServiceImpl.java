package cn.cooode.activityTools.service.impl;

import cn.cooode.activityTools.dao.UserDao;
import cn.cooode.activityTools.entity.User;
import cn.cooode.activityTools.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by BaiYunfei on 2017/1/3.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    public User get(Long id) {
        return userDao.get(id);
    }

    public User save(User user) {
        return userDao.save(user);
    }

    public User update(User user) {
        userDao.update(user);
        return user;
    }

    public void delete(User user) {
        userDao.delete(user.getId());
    }

    public User login(String username, String password) {
        User user = userDao.getByUsername(username);
        //用户不存在则登录失败，返回null
        if (user == null) {
            return null;
        }
        //比较密码
        if(user.getPassword().equals(password)){
            return user;
        }
        user.setLastLoginTime(new Date());
        //密码错误
        return null;
    }


    public boolean isEmpty(String username) {
        User user = userDao.getByUsername(username);
        return user==null?true:false;
    }

    public boolean existUsername(String username) {
        User user = userDao.getByUsername(username);
        return user==null?false:true;
    }
}
