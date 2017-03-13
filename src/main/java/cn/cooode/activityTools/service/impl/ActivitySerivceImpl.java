package cn.cooode.activityTools.service.impl;

import cn.cooode.activityTools.dao.ActivityDao;
import cn.cooode.activityTools.entity.Activity;
import cn.cooode.activityTools.entity.Pager;
import cn.cooode.activityTools.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by BaiYunfei on 2017/1/4.
 */
@Service
@Transactional
public class ActivitySerivceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    public Pager<Activity> getPager() {
        return activityDao.find("from Activity a where a.activityCheck.pass = true");
    }

    public Pager<Activity> getPagerByCategory(Long categoryId) {
        return activityDao.find("from Activity a where a.activityCheck.pass = true and a.category.id = ?",categoryId);
    }

    public Activity get(Long id) {
        return activityDao.get(id);
    }

    public Pager<Activity> getEnrolled(Long userId) {
        return activityDao.find("from Activity a where a.id in ( select enroll.activity.id from Enroll enroll where enroll.activity.id=a.id and enroll.user.id=?)",userId);
    }

    public Pager<Activity> getPassed(Long userId) {
        return activityDao.find("from Activity a where a.id in ( select enroll.activity.id from Enroll enroll where enroll.activity.id=a.id and enroll.user.id=?) and startTime > ?",userId,new Date());
    }

    public Pager<Activity> getPublished(Long userId) {
        return activityDao.find("from Activity where author.id=?",userId);
    }

    public Activity save(Activity activity) {
        return activityDao.save(activity);
    }

}
