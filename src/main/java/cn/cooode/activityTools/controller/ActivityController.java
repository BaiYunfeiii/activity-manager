package cn.cooode.activityTools.controller;

import cn.cooode.activityTools.constants.SessionConstants;
import cn.cooode.activityTools.entity.Activity;
import cn.cooode.activityTools.entity.Category;
import cn.cooode.activityTools.service.ActivityService;
import cn.cooode.activityTools.service.CategoryService;
import cn.cooode.activityTools.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by BaiYunfei on 2017/1/4.
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    EnrollService enrollService;

    @RequestMapping("/{articleId}")
    public String detials(@PathVariable("articleId") Long id, Model model, HttpSession session){
        Activity activity = activityService.get(id);
        boolean hasEnrolled = enrollService.hasEnrolled(id,(Long)session.getAttribute(SessionConstants.USER_ID));
        model.addAttribute("activity",activity);
        model.addAttribute("hasEnrolled",hasEnrolled);
        return "activityDetials";
    }

    @RequestMapping("/category/{categoryId}")
    public String category(@PathVariable("categoryId") Long categoryId, Model model){
        Category category = categoryService.get(categoryId);
        model.addAttribute("category",category);
        model.addAttribute("categoryId",categoryId);
        return "index";
    }

}
