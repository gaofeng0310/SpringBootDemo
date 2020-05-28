/**
 * 版权声明： 版权所有 违者必究 2020
*/
package com.xnpool.gaogtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xnpool.gaogtest.entity.TUserLogin;
import com.xnpool.gaogtest.mapper.TUserLoginMapper;


/**
 * <p>业务接口实现类</p>
 * <p></p>
 *
 * @author gaog
 * @since 2020-05-22 04:54:56
 */
@Service
@Transactional
public class TUserLoginServiceImpl extends ServiceImpl<TUserLoginMapper, TUserLogin> implements TUserLoginService {

}