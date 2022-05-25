package com.jr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jr.entity.User;
import com.jr.mapper.UserMapper;
import com.jr.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mr.hu
 * @since 2022-05-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
