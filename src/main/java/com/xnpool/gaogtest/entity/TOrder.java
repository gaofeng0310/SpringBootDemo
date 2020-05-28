/**
 * 版权声明： 版权所有 违者必究 2020
*/
package com.xnpool.gaogtest.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;
import java.math.BigDecimal;

/**
 * <p>Table: t_order - </p>
 *
 * @author gaog
 * @since 2020-05-22 04:58:27
 */
@Data
public class TOrder{

    /** id -  */
	@TableId(type = IdType.AUTO)
    private Integer id;

    /** uid -  */
    private Integer uid;

    /** order_name -  */
    private String orderName;

    /** pay_money -  */
    private String payMoney;

    /** order_status -  */
    private Integer orderStatus;

    /** create_time -  */
    private Date createTime;

}