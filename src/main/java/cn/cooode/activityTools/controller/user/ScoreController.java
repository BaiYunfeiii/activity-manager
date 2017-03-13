package cn.cooode.activityTools.controller.user;

import cn.cooode.activityTools.dto.ResultDto;
import cn.cooode.activityTools.entity.Activity;
import cn.cooode.activityTools.entity.Score;
import cn.cooode.activityTools.service.ActivityService;
import cn.cooode.activityTools.service.EnrollService;
import cn.cooode.activityTools.service.ScoreService;
import cn.cooode.activityTools.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by BaiYunfei on 2017/1/8.
 */
@Controller
@RequestMapping("/user/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;
    @Autowired
    UserService userService;
    @Autowired
    ActivityService activityService;
    @Autowired
    EnrollService enrollService;

    @RequestMapping("/update")
    public @ResponseBody
    ResultDto update(Long scoreId,Double scoreValue){
        Score score = scoreService.get(scoreId);
        score.setScore(scoreValue);
        scoreService.update(score);
        return new ResultDto(true);
    }

    @RequestMapping("/save")
    public @ResponseBody ResultDto save(Long activityId,Long userId,Double scoreValue,Integer round){
        if(!enrollService.hasEnrolled(activityId,userId)){
            return new ResultDto(false,"该用户未报名此次活动");
        }
        Activity activity = activityService.get(activityId);
        if(round == null || round > activity.getRound()){
            return new ResultDto(false,"超出最大阶段数量:"+round);
        }

        Score score = new Score();
        score.setUser(userService.get(userId));
        score.setActivity(activity);
        score.setScore(scoreValue);
        score.setRound(round);
        scoreService.save(score);
        return new ResultDto(true);
    }

    @RequestMapping("/delete")
    public @ResponseBody ResultDto delete(Long scoreId){
        scoreService.delete(scoreId);
        return new ResultDto(true);
    }

}
