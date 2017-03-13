package cn.cooode.activityTools.interceptor;

import cn.cooode.activityTools.util.SystemContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 分页的拦截器
 * Created by BaiYunfei on 2017/1/4.
 */
public class PageInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");
        if(null != pageSize && pageSize.length() > 0){
            SystemContext.setPageSize(Integer.parseInt(pageSize));
        }
        if(null != pageNum && pageNum.length() > 0){
            SystemContext.setPageOffset(Integer.parseInt(pageNum));
        }
        return true;
    }
}
