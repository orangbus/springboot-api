package com.orangbus.video.config;

import com.orangbus.video.interceptor.CheckUserLogin;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CheckLoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CheckUserLogin())
                // 需要拦截的地址
                .addPathPatterns("/**")
                // 排除静态资源
                .excludePathPatterns("/bootstrap5/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/hls/**")
                .excludePathPatterns("/hls/**")
                .excludePathPatterns("/jquery/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/layer/**")
                .excludePathPatterns("/video/**")
                // 排除地址
                .excludePathPatterns("/joke/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/login")
                .excludePathPatterns("/register")
                .excludePathPatterns("/user/register");
    }
}
