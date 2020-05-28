package com.xnpool.gaogtest.config.annotation.support;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xnpool.gaogtest.config.Constant;
import com.xnpool.gaogtest.config.annotation.Login;
import com.xnpool.gaogtest.config.annotation.LoginAdmin;
import com.xnpool.gaogtest.config.exception.RException;
import com.xnpool.gaogtest.config.exception.ResponseCodeEnum;
import com.xnpool.gaogtest.entity.TUserLogin;
import com.xnpool.gaogtest.service.TUserLoginService;
import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;


public class LoginAdminHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private TUserLoginService loginService;

    public LoginAdminHandlerMethodArgumentResolver(){
        super();
    }

    public LoginAdminHandlerMethodArgumentResolver(TUserLoginService loginService){
        super();
        this.loginService = loginService;
    }
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return  parameter.getParameterType().isAssignableFrom(TUserLogin.class)&&parameter.hasParameterAnnotation(LoginAdmin.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {

        LoginAdmin loginAdmin = parameter.getParameterAnnotation(LoginAdmin.class);
//        String token = request.getNativeRequest(HttpServletRequest.class).getParameter(Constant.TOKEN);
        String token = request.getNativeRequest(HttpServletRequest.class).getHeader(Constant.TOKEN);
        if (token == null || token.isEmpty()) {
            throw new RException(ResponseCodeEnum.TOKEN_INVALID);
        }
        //默认token 非必须登录返回null
        if(loginAdmin.value()==0){
            return null;
        }
        QueryWrapper<TUserLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("token",token);
        TUserLogin login = loginService.getOne(queryWrapper);
        if (login==null){
            throw new RException(ResponseCodeEnum.TOKEN_INVALID);
        }

        if (login!=null && loginAdmin.value()==1){

            MDC.clear();
            MDC.put("userId", ""+login.getUid());
        }
        return login;
    }

    public TUserLoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(TUserLoginService loginService) {
        this.loginService = loginService;
    }
}
