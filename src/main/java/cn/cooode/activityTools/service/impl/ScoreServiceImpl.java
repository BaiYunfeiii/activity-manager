package cn.cooode.activityTools.service.impl;

import cn.cooode.activityTools.dao.ScoreDao;
import cn.cooode.activityTools.entity.Pager;
import cn.cooode.activityTools.entity.Score;
import cn.cooode.activityTools.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by BaiYunfei on 2017/1/8.
 */
@Service
@Transactional
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreDao scoreDao;

    public Score get(Long id) {
        return scoreDao.get(id);
    }

    public Score save(Score score) {
        return scoreDao.save(score);
    }

    public void update(Score score) {
        scoreDao.update(score);
    }

    public void delete(Long id){
        scoreDao.delete(id);
    }

    public Pager<Score> getPager(Long activityId) {
        return scoreDao.find("from Score where activity.id = ?",activityId);
    }

    public Pager<Score> getPager(Long activityId,String query) {
        String hql = "from Score where activity.id = ? and ( user.name like ? or user.phone like ? or user.email like ?)";
        return scoreDao.find(hql,
                activityId,
                "%"+query+"%",
                "%"+query+"%",
                "%"+query+"%");
    }
}
