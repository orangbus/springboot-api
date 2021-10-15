package com.orangbus.video.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 1、定义一个拦截器，判断是否登录拦截
 * 2、把拦截器的配置放到容器中
 * 3、
 */
@Component
@Slf4j
public class CheckUserLogin implements HandlerInterceptor {

    /**
     * 页面还没有到达控制器处理的方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Url:"+request.getRequestURI());
        if (request.getSession().getAttribute("user") == null){
            HttpSession session = request.getSession();
            request.setAttribute("msg","请登录后操作！");
//            response.sendRedirect("/login");
            // 将消息放到 request 作用域中
            request.getRequestDispatcher("/login").forward(request,response);
        };
        return true;
    }

    /**
     * 方法执行之后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 页面渲染之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
