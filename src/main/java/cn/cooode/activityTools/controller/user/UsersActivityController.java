package cn.cooode.activityTools.controller.user;

import cn.cooode.activityTools.constants.SessionConstants;
import cn.cooode.activityTools.dto.ActivityDto;
import cn.cooode.activityTools.dto.ResultDto;
import cn.cooode.activityTools.entity.*;
import cn.cooode.activityTools.service.*;
import cn.cooode.activityTools.util.SystemContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by BaiYunfei on 2017/1/4.
 */
@Controller
@RequestMapping("/user/activity")
public class UsersActivityController {

    @Autowired
    ActivityService activityService;
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    EnrollService enrollService;
    @Autowired
    ActivityCheckSerivce activityCheckSerivce;
    @Autowired
    ScoreService scoreService;

    @RequestMapping("/enroll")
    public @ResponseBody
    ResultDto enroll(Long id, HttpSession session){
        Long userId = (Long)session.getAttribute(SessionConstants.USER_ID);
        if(!enrollService.hasEnrolled(id,userId)) {
            Enroll enroll = new Enroll();
            enroll.setActivity(activityService.get(id));
            enroll.setUser(userService.get(userId));
            enroll.setEnrollTime(new Date());
            enrollService.save(enroll);
            return new ResultDto(true,"");
        }else{
            return new ResultDto(false,"您已经报名了");
        }
    }

    @RequestMapping("/publish")
    public String publish(ActivityDto activityDto, Model model, HttpSession session){
        System.out.println(activityDto.getName());
        User user = userService.get((Long) session.getAttribute(SessionConstants.USER_ID));
        Category category = categoryService.get(activityDto.getCategoryId());

        Activity activity = new Activity();
        activity.setCategory(category);
        activity.setAuthor(user);
        activity.setOrganizer(activityDto.getOrganizer());
        activity.setName(activityDto.getName());
        activity.setDescription(activityDto.getDescription());
        activity.setLocation(activityDto.getLocation());
        try {
            activity.setStartTime(new SimpleDateFormat("yyyy-MM-dd").parse(activityDto.getStartTime()));
        } catch (ParseException e) {
            activity.setStartTime(null);
            e.printStackTrace();
        }
        activity.setPublishTime(new Date());

        activityService.save(activity);

        //新增审核
        ActivityCheck activityCheck = new ActivityCheck(activity);
        activityCheckSerivce.save(activityCheck);

        return "redirect:/index";
    }

//    @RequestMapping("/enroll/info/{activityId}")
//    public String enrollInfo(@PathVariable("activityId") Long activityId, Model model){
//        if(activityId!=null){
//            Activity activity = activityService.get(activityId);
//            Pager<Enroll> enrollPager = enrollService.getEnrollTable(activityId);
//            model.addAttribute("enrollPager",enrollPager);
//            model.addAttribute("activity",activity);
//        }
//        return "user/activity/enrollInfo";
//    }

    @RequestMapping("/{activityId}/enroll/info")
    public String enrollInfo(@PathVariable("activityId") Long activityId, Model model){
        if(activityId!=null){
            Activity activity = activityService.get(activityId);
            Pager<Enroll> enrollPager = enrollService.getEnrollTable(activityId);
            model.addAttribute("enrollPager",enrollPager);
            model.addAttribute("activity",activity);
        }
        return "user/activity/enrollDetails";
    }

    @RequestMapping("/{activityId}/info")
    public String activityInfo(@PathVariable("activityId")Long id, Model model){
        Activity activity = activityService.get(id);
        model.addAttribute("activity",activity);
        return "user/activity/activityInfo";
    }

    @RequestMapping("/{activityId}/scores")
    public String scoreList(@PathVariable("activityId") Long activityId,String query, Model model){
        SystemContext.setPageSize(10);
        Pager<Score> scorePager;
        if(query != null) {
            scorePager = scoreService.getPager(activityId, query);
        }else{
            scorePager = scoreService.getPager(activityId);
        }
        model.addAttribute("scorePager",scorePager);
        model.addAttribute("activity",activityService.get(activityId));
        return "user/activity/score";
    }

}
