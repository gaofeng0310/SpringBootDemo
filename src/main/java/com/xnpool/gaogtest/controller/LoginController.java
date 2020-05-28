package com.xnpool.gaogtest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xnpool.gaogtest.entity.ResponseResult;
import com.xnpool.gaogtest.entity.TUser;
import com.xnpool.gaogtest.entity.TUserLogin;
import com.xnpool.gaogtest.service.TUserLoginService;
import com.xnpool.gaogtest.service.TUserService;
import com.xnpool.gaogtest.utils.DateUtil;
import com.xnpool.gaogtest.utils.UUIDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@Api(description = "用户登陆接口")
@RestController
public class LoginController {

    @Autowired
    private TUserService userService;

    @Autowired
    private TUserLoginService loginService;

    @ApiOperation(value = "用户登陆")
    @RequestMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public Object login( @RequestParam(value = "username") String username,
                         @RequestParam(value = "password") String password) {

        //判断不能重复添加
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username)
        .eq("password",password);
        TUser user=userService.getOne(queryWrapper);
        if(user==null){
            return new ResponseResult(ResponseResult.SUCCESS, "用户名或密码错误");
        }

        Date date = new Date();
        TUserLogin login = new TUserLogin();
        login.setUid(user.getUid());
        login.setLoginTime(date);
        login.setToken(UUIDUtil.createUUID32());
        login.setExpireTime(DateUtil.addMinute(date,12*60));
        loginService.saveOrUpdate(login);
        Map<String,String> map = new HashMap<>();
        map.put("token",login.getToken());
        return new ResponseResult(ResponseResult.SUCCESS, map);
    }
}
