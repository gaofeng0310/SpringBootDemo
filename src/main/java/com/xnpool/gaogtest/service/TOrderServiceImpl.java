/**
 * 版权声明： 版权所有 违者必究 2020
*/
package com.xnpool.gaogtest.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xnpool.gaogtest.request.OrderRequest;
import com.xnpool.gaogtest.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xnpool.gaogtest.entity.TOrder;
import com.xnpool.gaogtest.mapper.TOrderMapper;


/**
 * <p>业务接口实现类</p>
 * <p></p>
 *
 * @author gaog
 * @since 2020-05-18 05:55:32
 */
@Service
@Transactional
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService {

    @Override
    public IPage<OrderResponse> listPage(IPage<TOrder> page, OrderRequest request) {
        return baseMapper.listPage(page,request);
    }
}