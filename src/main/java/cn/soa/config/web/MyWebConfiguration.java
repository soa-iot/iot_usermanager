package cn.soa.config.web;

import javax.servlet.ServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@Configuration
//public class MyWebConfiguration extends WebMvcConfigurationSupport {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//        		.allowedOrigins("*")
//        		.allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//        		.maxAge(3600)
//        		.allowCredentials(true);
//    }
//    
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        super.addResourceHandlers(registry);
//    }
//
//
//}
