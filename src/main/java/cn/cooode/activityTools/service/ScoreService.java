package cn.cooode.activityTools.service;

import cn.cooode.activityTools.entity.Pager;
import cn.cooode.activityTools.entity.Score;

/**
 * Created by BaiYunfei on 2017/1/8.
 */
public interface ScoreService {

    public Score get(Long id);

    public Score save(Score score);

    public void update(Score score);

    public void delete(Long id);

    public Pager<Score> getPager(Long activityId);

    public Pager<Score> getPager(Long activityId,String query);

}
