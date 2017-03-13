package cn.cooode.activityTools.controller.admin;

import cn.cooode.activityTools.constants.SessionConstants;
import cn.cooode.activityTools.entity.ActivityCheck;
import cn.cooode.activityTools.entity.Category;
import cn.cooode.activityTools.entity.Pager;
import cn.cooode.activityTools.service.ActivityCheckSerivce;
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
 * Created by BaiYunfei on 2017/1/5.
 */
@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;
    @Autowired
    ActivityCheckSerivce activityCheckSerivce;

    @RequestMapping({"","/index"})
    public String index(){
        return "redirect:/admin/category";
    }

    @RequestMapping("/category")
    public String list(Model model, HttpSession session){
        List<Category> categoryList = categoryService.list();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("user",userService.get((Long)session.getAttribute(SessionConstants.USER_ID)));
        return "admin/category";
    }

    @RequestMapping("/check")
    public String checkList(Model model){
        SystemContext.setPageSize(15);
        Pager<ActivityCheck> activityCheckPager = activityCheckSerivce.getPager();
        model.addAttribute("activityCheckPager",activityCheckPager);
        return "admin/check";
    }

}
