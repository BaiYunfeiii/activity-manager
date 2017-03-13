package cn.cooode.activityTools.service;

import cn.cooode.activityTools.entity.User;

/**
 * Created by BaiYunfei on 2017/1/3.
 */
public interface UserService {

    User get(Long id);

    User save(User user);

    User update(User user);

    void delete(User user);

    User login(String username, String password);

    boolean isEmpty(String username);

    boolean existUsername(String username);

}
