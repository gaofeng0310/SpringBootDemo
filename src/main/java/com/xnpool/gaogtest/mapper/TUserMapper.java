package com.xnpool.gaogtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xnpool.gaogtest.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 表说明：
 *
 * @author gaog
 * @since 2020-05-15 03:43:43
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {

    @Select("select count(1) from t_user")
    int userCount();
    
}