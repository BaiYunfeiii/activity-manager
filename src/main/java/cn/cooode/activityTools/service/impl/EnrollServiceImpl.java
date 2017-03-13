package cn.cooode.activityTools.service.impl;

import cn.cooode.activityTools.dao.ActivityDao;
import cn.cooode.activityTools.dao.EnrollDao;
import cn.cooode.activityTools.entity.Activity;
import cn.cooode.activityTools.entity.Enroll;
import cn.cooode.activityTools.entity.Pager;
import cn.cooode.activityTools.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by BaiYunfei on 2017/1/5.
 */
@Service
@Transactional
public class EnrollServiceImpl implements EnrollService {

    @Autowired
    EnrollDao enrollDao;
    @Autowired
    ActivityDao activityDao;

    public Enroll save(Enroll enroll) {
        return enrollDao.save(enroll);
    }

    public boolean hasEnrolled(Long activityId, Long userId) {
        Enroll enroll = (Enroll)enrollDao.queryObject("from Enroll where activity.id = ? and user.id = ?",activityId,userId);
        return enroll!=null;
    }

    public Pager<Enroll> getEnrollTable(Long activityId) {
        String hql = "from Enroll enroll where enroll.activity.id = ?";
        return enrollDao.find(hql,activityId);
    }
}
