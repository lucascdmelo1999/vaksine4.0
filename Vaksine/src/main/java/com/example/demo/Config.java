package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import acesso.Acesso;



@Configuration
public class Config implements WebMvcConfigurer {


@Override
public void addInterceptors(InterceptorRegistry registry) {
registry.addInterceptor((HandlerInterceptor) new Acesso());
}

}

