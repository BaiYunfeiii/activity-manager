package cn.cooode.activityTools.service;

import cn.cooode.activityTools.entity.Enroll;
import cn.cooode.activityTools.entity.Pager;

/**
 * Created by BaiYunfei on 2017/1/5.
 */
public interface EnrollService {

    public Enroll save(Enroll enroll);

    public boolean hasEnrolled(Long activityId,Long userId);

    public Pager<Enroll> getEnrollTable(Long activityId);

}
