package cn.cooode.activityTools.interceptor;

/**
 * Created by BaiYunfei on 2017/1/3.
 */

import cn.cooode.activityTools.constants.SessionConstants;
import cn.cooode.activityTools.entity.User;
import cn.cooode.activityTools.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by BaiYunfei on 2016/12/1.
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object userId = session.getAttribute(SessionConstants.USER_ID);
        if(userId==null){
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }
        User user = userService.get((Long)userId);
        request.setAttribute("user",user);
        return true;
    }
}
