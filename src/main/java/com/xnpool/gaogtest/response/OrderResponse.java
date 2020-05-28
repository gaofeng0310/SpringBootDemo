/**
 * 版权声明： 版权所有 违者必究 2020
*/
package com.xnpool.gaogtest.response;

import java.util.Date;

/**
 * <p>Table: t_order - </p>
 *
 * @author gaog
 * @since 2020-05-18 05:55:32
 */
public class OrderResponse  {

    private Integer id;
    private Integer uid;

    /** order_name -  */
    private String orderName;

    private String username;

    /** pay_money -  */
    private String payMoney;

    /** orderSatus -  */
    private Integer orderStatus;

    /** create_time -  */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}