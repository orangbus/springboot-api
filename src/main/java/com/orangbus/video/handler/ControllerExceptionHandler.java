package com.orangbus.video.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * 预处理
 */
@ControllerAdvice // 拦击标注为 controller
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class) // 标注为可以处理异常类的方法
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Request Url:{},Exception:{}",request.getRequestURI(),e);

        // 如果发生了异常，没有指定状态码的话就交给下一个异常处理器处理
        // @ResponseStatus(HttpStatus.NOT_FOUND)
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }

        // 返回自定义的错误页面
        ModelAndView view = new ModelAndView();
        view.addObject("url",request.getRequestURI());
        view.addObject("exception",e);
        // custom error pages
        view.setViewName("error/index");
        return view;
    }
}






















