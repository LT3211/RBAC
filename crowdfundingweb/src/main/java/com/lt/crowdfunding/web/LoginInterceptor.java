package com.lt.crowdfunding.web;

import com.lt.crowdfunding.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 在控制器执行之前完成业务逻辑操作
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return  方法的返回值决定逻辑是否继续执行，true表示继续执行，false表示不继续执行
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        //判断当前的用户是否已经登陆
        HttpSession session=httpServletRequest.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        String path=httpServletRequest.getSession().getServletContext().getContextPath();

        if (loginUser==null){
            httpServletResponse.sendRedirect(path+"/login");
            return false;
        }else {
            return true;
        }
    }

    /**
     * 控制器执行完毕之后执行的逻辑操作
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在完成视图渲染之后，执行此方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
