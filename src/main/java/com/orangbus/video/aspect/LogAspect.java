package com.orangbus.video.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class LogAspect {


    /**
     * 定义一个切面
     * 所有的请求拦截 那个包下面的所有方法及（参数）
     */
    @Pointcut("execution(* com.orangbus.video.*.*(..))")
    public void log(){};

    /**
     * 请求之前
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        log.info("请求之前");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURI();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url,ip,classMethod,args);
        log.info("Request:{}",requestLog);
    }

    /**
     * 请求之后
     */
    @After("log()")
    public void doAfter(){
        log.info("请求之后");
    }

    /**
     * 方法返回
     */
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
        log.info("方法返回");

        log.info("Result:{}",result);
    }

    /**
     * 构造一个请求日志参数
     */
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod; //请求方法
        private Object[] args; // 请求参数

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }

}
