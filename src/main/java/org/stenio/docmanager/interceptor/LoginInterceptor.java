package org.stenio.docmanager.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by stenio on 2017/4/16.
 */
public class LoginInterceptor implements HandlerInterceptor {

    private List<String> whiteNames;



    public void setWhiteNames(List<String> whiteNames){
        this.whiteNames = whiteNames;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(whiteNames.contains(request.getRequestURI())){
            return true;
        }
        if(hasLogined(request)){
            return true;
        }
        response.sendRedirect("/login");
        return false;
    }

    private boolean hasLogined(HttpServletRequest request) {
        return request.getSession().getAttribute("user") != null;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
