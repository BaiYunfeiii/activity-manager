package cn.cooode.activityTools.controller;

import cn.cooode.activityTools.constants.EntityConstants;
import cn.cooode.activityTools.constants.SessionConstants;
import cn.cooode.activityTools.dto.UserDto;
import cn.cooode.activityTools.entity.Activity;
import cn.cooode.activityTools.entity.Pager;
import cn.cooode.activityTools.entity.User;
import cn.cooode.activityTools.service.ActivityService;
import cn.cooode.activityTools.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

/**
 * Created by BaiYunfei on 2017/1/3.
 */
@RequestMapping("/")
@Controller
public class HomeController {

    @Autowired
    ActivityService activityService;
    @Autowired
    UserService userService;

    @RequestMapping({"","index"})
    public String index(Model model){
        Pager<Activity> activityPager = activityService.getPager();
        model.addAttribute("activityPager",activityPager);
        return "index";
    }

    @RequestMapping("loginPage")
    public String login(){
        return "login";
    }

    @RequestMapping("registerPage")
    public String registerPage(){
        return "register";
    }

    @RequestMapping("login")
    public String doLogin(String username, String password, Model model, HttpSession session){
        User user = userService.login(username,password);
        if(user!=null){
            session.setAttribute(SessionConstants.USER_ID,user.getId());
        }else{
            model.addAttribute("error","用户名或密码错误");
            return "forward:/loginPage";
        }
        return "redirect:/index";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute(SessionConstants.USER_ID);
        return "redirect:/index";
    }

    @RequestMapping("register")
    public String register(UserDto userDto, Model model, HttpSession session){
        String error = "";
        if(userDto.getUsername()==null){
            error += "用户名不能为空，";
        }
        if(userService.existUsername(userDto.getUsername())){
            error += "用户名已经被注册";
        }
        if(userDto.getPassword() == null || userDto.getPassword().length()==0){
            error += "密码不能为空";
        }
        if(!userDto.getPassword().equals(userDto.getRepassword())){
            error += "两次密码不一致";
        }
        if(userDto.getPhone() == null){
            error += "电话号码不能为空";
        }
        if(error.length()>0){
            model.addAttribute("error",error);
            return "register";
        }

        User user = userDto.toUser();
        user.setRegisterTime(new Date());
        user.setRole(EntityConstants.USER_TYPE_NORMAL);

        user = userService.save(user);
        session.setAttribute(SessionConstants.USER_ID,user.getId());
        return "redirect:/index";
    }

}
