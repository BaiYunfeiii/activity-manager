package cn.cooode.activityTools.service;

import cn.cooode.activityTools.entity.ActivityCheck;
import cn.cooode.activityTools.entity.Pager;

/**
 * Created by BaiYunfei on 2017/1/5.
 */
public interface ActivityCheckSerivce {

    public ActivityCheck save(ActivityCheck activityCheck);

    public Pager<ActivityCheck> getPager();

    public ActivityCheck get(Long id);

    public void update(ActivityCheck activityCheck);

    public ActivityCheck handle(Long id,boolean process,Long userId);

}
