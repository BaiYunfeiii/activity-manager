package cn.cooode.activityTools.interceptor;

import cn.cooode.activityTools.constants.SessionConstants;
import cn.cooode.activityTools.entity.User;
import cn.cooode.activityTools.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by BaiYunfei on 2017/1/5.
 */
@Component
public class RoleInterceptor extends HandlerInterceptorAdapter {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = userService.get((Long)request.getSession().getAttribute(SessionConstants.USER_ID));
        switch (user.getRole()){
            case 9:return true;
            default:request.getServletContext().getRequestDispatcher("/index").forward(request,response);return false;
        }
    }
}
