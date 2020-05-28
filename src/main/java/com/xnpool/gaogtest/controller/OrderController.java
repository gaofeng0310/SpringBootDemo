package com.xnpool.gaogtest.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xnpool.gaogtest.config.annotation.LoginAdmin;
import com.xnpool.gaogtest.entity.ResponseResult;
import com.xnpool.gaogtest.entity.TOrder;
import com.xnpool.gaogtest.entity.TUserLogin;
import com.xnpool.gaogtest.request.OrderRequest;
import com.xnpool.gaogtest.response.OrderResponse;
import com.xnpool.gaogtest.service.TOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "订单接口")
@RestController
public class OrderController {

    @Autowired
    private TOrderService tOrderService;

    @ApiOperation(value = "订单列表")
    @RequestMapping(value = "/order/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public Object list(@LoginAdmin TUserLogin login, OrderRequest request) {

        IPage<TOrder> page = new Page<>(request.getPage(),request.getSize());
        IPage<OrderResponse> page1 = tOrderService.listPage(page,request);

        return new ResponseResult(ResponseResult.SUCCESS, page1);
    }
}
