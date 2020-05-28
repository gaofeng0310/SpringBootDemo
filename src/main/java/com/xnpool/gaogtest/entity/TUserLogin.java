/**
 * 版权声明： 版权所有 违者必究 2020
*/
package com.xnpool.gaogtest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * <p>Table: t_user_login - </p>
 *
 * @author gaog
 * @since 2020-05-22 04:54:56
 */
@Data
public class TUserLogin{

    /** uid -  */
	@TableId(type = IdType.AUTO)
    private Integer uid;

    /** token -  */
    private String token;

    /** expire_time - 过期时间 */
    private Date expireTime;

    /** login_time - 登陆时间 */
    private Date loginTime;

}