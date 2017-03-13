package cn.cooode.activityTools.controller.admin;

import cn.cooode.activityTools.constants.SessionConstants;
import cn.cooode.activityTools.dto.ResultDto;
import cn.cooode.activityTools.entity.ActivityCheck;
import cn.cooode.activityTools.entity.User;
import cn.cooode.activityTools.service.ActivityCheckSerivce;
import cn.cooode.activityTools.service.ActivityService;
import cn.cooode.activityTools.service.UserService;
import cn.cooode.activityTools.util.SystemContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import java.util.Date;

/**
 * Created by BaiYunfei on 2017/1/5.
 */
@RequestMapping("/admin/check")
@Controller
public class ActivityCheckController {

    @Autowired
    ActivityService activityService;
    @Autowired
    ActivityCheckSerivce activityCheckSerivce;
    @Autowired
    UserService userService;

    @RequestMapping("/handle")
    public @ResponseBody
    ResultDto process(Long id, Boolean process, HttpSession session){
        activityCheckSerivce.handle(id,process,(Long)session.getAttribute(SessionConstants.USER_ID));
        return new ResultDto(true);
    }



}
