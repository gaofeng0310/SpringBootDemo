/**
 * 版权声明： 版权所有 违者必究 2020
*/
package com.xnpool.gaogtest.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>Table: t_user - </p>
 *
 * @author gaog
 * @since 2020-05-15 03:43:43
 */
@TableName("t_user")
public class TUser{

    /** uid -  */
	@TableId(type = IdType.AUTO)
    private Integer uid;

    /** userName -  */
    private String username;

    /** password -  */
    private String password;

    /** age -  */
    private Integer age;

    /** sex -  */
    private String sex;

    /** idDelete -  */
    private Integer iddelete;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getIddelete() {
        return iddelete;
    }

    public void setIddelete(Integer iddelete) {
        this.iddelete = iddelete;
    }
}