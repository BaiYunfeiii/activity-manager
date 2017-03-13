package cn.cooode.activityTools.service;

import cn.cooode.activityTools.entity.Activity;
import cn.cooode.activityTools.entity.Pager;

/**
 * Created by BaiYunfei on 2017/1/4.
 */
public interface ActivityService {

    public Pager<Activity> getPager();

    public Pager<Activity> getPagerByCategory(Long categoryId);

    public Activity get(Long id);

    public Pager<Activity> getEnrolled(Long userId);

    public Pager<Activity> getPassed(Long userId);

    public Pager<Activity> getPublished(Long userId);

    Activity save(Activity activity);

}
