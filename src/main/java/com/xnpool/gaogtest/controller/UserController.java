package com.xnpool.gaogtest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xnpool.gaogtest.config.annotation.LoginAdmin;
import com.xnpool.gaogtest.entity.ResponseResult;
import com.xnpool.gaogtest.entity.TUser;
import com.xnpool.gaogtest.entity.TUserLogin;
import com.xnpool.gaogtest.request.UserRequest;
import com.xnpool.gaogtest.service.TUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户操作接口")
@RestController
public class UserController {

    @Autowired
    private TUserService tUserService;

    @ApiOperation(value = "用户添加")
    @RequestMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE)
    public Object insert(@LoginAdmin TUserLogin login, @RequestBody TUser  tUser) {

        //判断不能重复添加
        QueryWrapper<TUser>  queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",tUser.getUsername());
        TUser user = tUserService.getOne(queryWrapper);
        if(user!=null){
            return new ResponseResult(ResponseResult.SUCCESS, "用户已存在");
        }
        boolean b= tUserService.save(tUser);
        return new ResponseResult(ResponseResult.SUCCESS, b);
    }

    @ApiOperation(value = "用户列表")
    @RequestMapping(value = "/list")
    public Object list(@LoginAdmin TUserLogin login, UserRequest userRequest) {

        IPage<TUser> page = new Page<>(userRequest.getPage(),userRequest.getSize());
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(userRequest.getUsername()),"username",userRequest.getUsername());
        page = tUserService.page(page,queryWrapper);
        return new ResponseResult(ResponseResult.SUCCESS, page);
    }
    @ApiOperation(value = "用户列表")
    @GetMapping(value = "/getUserByName")
    public Object getUserByName(@LoginAdmin TUserLogin login, String username) {
        if(StringUtils.isBlank(username)){
            return new ResponseResult(ResponseResult.FALSE, "username 不能为空");
        }
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        TUser tUser = tUserService.getOne(queryWrapper);
        if(tUser==null){
            return new ResponseResult(ResponseResult.SUCCESS, "用户不存在");
        }
        return new ResponseResult(ResponseResult.SUCCESS, tUser);
    }
    @ApiOperation(value = "用户编辑")
    @RequestMapping("/edit")
    public Object edit(@LoginAdmin TUserLogin login, Integer uid) {

        TUser tuser = tUserService.getById(uid);
        return new ResponseResult(ResponseResult.SUCCESS, tuser);
    }
    @ApiOperation(value = "用户更新")
    @RequestMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public Object update(@LoginAdmin TUserLogin login, @RequestBody TUser tUser) {

        Boolean b = tUserService.updateById(tUser);

        return new ResponseResult(ResponseResult.SUCCESS, b);
    }

    @ApiOperation(value = "用户删除")
    @RequestMapping("/delete")
    public Object delete(@LoginAdmin TUserLogin login, Integer uid) {

        TUser tUser = tUserService.getById(uid);
        if(tUser==null){
            return new ResponseResult(ResponseResult.SUCCESS, "用户不存在");
        }else if(tUser.getIddelete()==1){
            return new ResponseResult(ResponseResult.SUCCESS, "用户已删除");
        }

        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("iddelete",1);
        Boolean b = tUserService.removeById(uid);

        return new ResponseResult(ResponseResult.SUCCESS, b);
    }

}
