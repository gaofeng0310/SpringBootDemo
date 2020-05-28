package com.xnpool.gaogtest.config;

import com.xnpool.gaogtest.config.annotation.support.LoginAdminHandlerMethodArgumentResolver;
import com.xnpool.gaogtest.config.interceptor.AuthorizationInterceptor;
import com.xnpool.gaogtest.service.TUserLoginService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;
    @Autowired
    private TUserLoginService loginService;

    /**
     * 请求参数解析
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        在此处注入参数解析器，如下tokenService可能没有被初始化，依旧为null值，需要在applicationContext完成初始化后注入
//        argumentResolvers.add(new LoginAdminHandlerMethodArgumentResolver(tokenService));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册验签
        registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger**","/swagger-resources/**","/webjars/**","/v2/**","/configuration/**");
    }

    /*
     * 统一返回处理
     * 注册到容器,采用这种注册方式的目的:
     * 自定义的HandlerMethodReturnValueHandler放在默认实现的前面,从而优先采用自定义处理策略
     * 否则,无法覆盖@ResponseBody处理机制,且String类型的返回值将默认由ViewNameMethodReturnValueHandler处理而映射为视图名
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        List<HandlerMethodReturnValueHandler> returnValueHandlers = new ArrayList<>();
        //将自定义的结果处理器放置在最前面
        returnValueHandlers.addAll(requestMappingHandlerAdapter.getReturnValueHandlers());
        requestMappingHandlerAdapter.setReturnValueHandlers(returnValueHandlers);
        List<HandlerMethodArgumentResolver> argumentResolvers = new ArrayList<>();
        //将自定义的参数解析器放置在最前面
        argumentResolvers.add(new LoginAdminHandlerMethodArgumentResolver(loginService));
        argumentResolvers.addAll(requestMappingHandlerAdapter.getArgumentResolvers());
        requestMappingHandlerAdapter.setArgumentResolvers(argumentResolvers);

    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowCredentials(true)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .maxAge(3600);
    }

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
    }
}
