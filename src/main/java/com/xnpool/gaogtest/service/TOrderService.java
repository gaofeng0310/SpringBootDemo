/**
 * 版权声明： 版权所有 违者必究 2020
*/
package com.xnpool.gaogtest.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xnpool.gaogtest.entity.TOrder;
import com.xnpool.gaogtest.request.OrderRequest;
import com.xnpool.gaogtest.response.OrderResponse;

/**
 * <p>业务接口类</p>
 * <p></p>
 *
 * @author gaog
 * @since 2020-05-18 05:55:32
 */
public interface TOrderService extends IService<TOrder> {

    IPage<OrderResponse> listPage(IPage<TOrder> page, OrderRequest request);
}