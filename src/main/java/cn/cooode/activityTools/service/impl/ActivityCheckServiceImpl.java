package cn.cooode.activityTools.service.impl;

import cn.cooode.activityTools.dao.ActivityCheckDao;
import cn.cooode.activityTools.entity.ActivityCheck;
import cn.cooode.activityTools.entity.Pager;
import cn.cooode.activityTools.service.ActivityCheckSerivce;
import cn.cooode.activityTools.service.UserService;
import cn.cooode.activityTools.util.SystemContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by BaiYunfei on 2017/1/5.
 */
@Service
@Transactional
public class ActivityCheckServiceImpl implements ActivityCheckSerivce {

    @Autowired
    ActivityCheckDao activityCheckDao;
    @Autowired
    UserService userService;

    public ActivityCheck save(ActivityCheck activityCheck) {
        return activityCheckDao.save(activityCheck);
    }

    public Pager<ActivityCheck> getPager() {
        return activityCheckDao.find("from ActivityCheck order by processed asc,activity.publishTime desc");
    }

    public ActivityCheck get(Long id) {
        return activityCheckDao.get(id);
    }

    public ActivityCheck handle(Long id,boolean process,Long userId){
        ActivityCheck activityCheck = activityCheckDao.get(id);
        activityCheck.setPass(process);
        activityCheck.setCheckTime(new Date());
        activityCheck.setChecker(userService.get(userId));
        activityCheck.setProcessed(true);
        activityCheckDao.update(activityCheck);
        return activityCheck;
    }

    public void update(ActivityCheck activityCheck) {
        activityCheckDao.update(activityCheck);
    }
}
