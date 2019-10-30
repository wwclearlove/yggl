package com.cdivtc.interceptor;

import com.cdivtc.model.UUser;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TeacherInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
//        UUser user = (UUser) request.getSession().getAttribute("user");
//        if (user == null && user.getuFlag()!=1) {
//            response.sendRedirect("/index");
//            return false;
//        }
//        return true;
        return true;
    }
}
