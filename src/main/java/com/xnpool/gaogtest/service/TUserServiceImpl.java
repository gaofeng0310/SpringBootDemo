/**
 * 版权声明： 版权所有 违者必究 2020
*/
package com.xnpool.gaogtest.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xnpool.gaogtest.entity.TUser;
import com.xnpool.gaogtest.mapper.TUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>业务接口实现类</p>
 * <p></p>
 *
 * @author gaog
 * @since 2020-05-15 03:43:43
 */
@Service
@Transactional
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}