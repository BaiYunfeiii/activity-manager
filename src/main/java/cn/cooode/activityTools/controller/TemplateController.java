package cn.cooode.activityTools.controller;


import cn.cooode.activityTools.constants.SessionConstants;
import cn.cooode.activityTools.entity.Activity;
import cn.cooode.activityTools.entity.Category;
import cn.cooode.activityTools.entity.Pager;
import cn.cooode.activityTools.entity.User;
import cn.cooode.activityTools.service.ActivityService;
import cn.cooode.activityTools.service.CategoryService;
import cn.cooode.activityTools.service.UserService;
import cn.cooode.activityTools.util.SystemContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by BaiYunfei on 2017/1/4.
 */
@Controller
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    ActivityService activityService;
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/activityList")
    public String activityList(Long categoryId,Model model){
        SystemContext.setSort("publishTime");
        SystemContext.setOrder("desc");
        Pager<Activity> activityPager;
        if(categoryId!=null){
            activityPager = activityService.getPagerByCategory(categoryId);
        }else{
            activityPager = activityService.getPager();
        }
        model.addAttribute("activityPager",activityPager);
        return "templates/user/activityList";
    }

    @RequestMapping("/sideBar")
    public String sideBar(Model model, HttpSession session){
        Object id = session.getAttribute(SessionConstants.USER_ID);
        User user = null;
        if(null != id) {
            user = userService.get((Long) id);
        }
        model.addAttribute("user",user);
        return "templates/user/sidebar_userinfo";
    }

    @RequestMapping("/nav")
    public String nav(Model model, HttpSession session){
        List<Category> categoryList = categoryService.list();
        model.addAttribute("categoryList",categoryList);
        Object id = session.getAttribute(SessionConstants.USER_ID);
        User user = null;
        if(null != id) {
            user = userService.get((Long) id);
        }
        model.addAttribute("user",user);
        return "templates/user/nav";
    }
}
