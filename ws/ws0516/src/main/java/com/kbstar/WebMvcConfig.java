package com.kbstar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //이미지 dir
    @Value("${imgdir}")
    String imgdir;
    //로그 dir (카트 차트용)
    @Value("${logdir}")
    String logdir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uimg/**").addResourceLocations(imgdir);
        registry.addResourceHandler("/logs/**").addResourceLocations(logdir);
    }
}
