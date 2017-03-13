package cn.cooode.activityTools.controller.user;

import cn.cooode.activityTools.constants.SessionConstants;
import cn.cooode.activityTools.entity.*;
import cn.cooode.activityTools.service.ActivityService;
import cn.cooode.activityTools.service.CategoryService;
import cn.cooode.activityTools.service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * Created by BaiYunfei on 2017/1/4.
 */
@Controller
@RequestMapping("/user")
public class UserHomeController {

    @Autowired
    ActivityService activityService;
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/publishPage")
    public String publish(Model model){
        List<Category> categoryList = categoryService.list();
        model.addAttribute("categoryList",categoryList);
        return "user/publish";
    }

    @RequestMapping("/enrollPage/{activityId}")
    public String enroll(@PathVariable("activityId") Long activityId,Model model, HttpSession session){
        Activity activity = activityService.get(activityId);
        model.addAttribute("activity",activity);
        model.addAttribute("user",userService.get((Long)session.getAttribute(SessionConstants.USER_ID)));
        return "user/enroll";
    }

    @RequestMapping("/myActivity")
    public String myActivity(Byte type,Model model,HttpSession session){
        Pager<Activity> activityPager;
        Long userId = (Long)session.getAttribute(SessionConstants.USER_ID);
        String title = "";
        if(type == null) type = 1;
        //获取已报名的和发起的
        switch (type){
            case 1:activityPager = activityService.getEnrolled(userId);title="我参加的";break;
            case 2:activityPager = activityService.getPublished(userId);title="我发起的";break;
            default:activityPager = activityService.getEnrolled(userId);title="我参加的";break;
        }
        model.addAttribute("activityPager",activityPager);
        model.addAttribute("pageTitle",title);
        model.addAttribute("user",userService.get((Long)session.getAttribute(SessionConstants.USER_ID)));
        return "user/myActivity";
    }

    @RequestMapping("/info")
    public String info(Model model, HttpSession session){
        User user = userService.get((Long)session.getAttribute(SessionConstants.USER_ID));
        model.addAttribute("user",user);
        return "user/userInfo";
    }

    @RequestMapping("/myTeam")
    public String myTeam(HttpSession session){
        User user = userService.get((Long)session.getAttribute(SessionConstants.USER_ID));

        return "user/myTeam";
    }

}
