/**
 * 版权声明： 版权所有 违者必究 2020
*/
package com.xnpool.gaogtest.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xnpool.gaogtest.request.OrderRequest;
import com.xnpool.gaogtest.response.OrderResponse;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xnpool.gaogtest.entity.TOrder;
import org.apache.ibatis.annotations.Select;

/**
 * 表说明：
 *
 * @author gaog
 * @since 2020-05-18 05:55:32
 */
@Mapper
public interface TOrderMapper extends BaseMapper<TOrder> {

    @Select("select t.*,u.username from t_order t LEFT JOIN t_user u ON t.uid=u.uid ")
    IPage<OrderResponse> listPage(IPage<TOrder> page, OrderRequest request);
}