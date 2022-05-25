package com.jr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jr.entity.Roles;
import com.jr.entity.User;
import com.jr.mapper.RolesMapper;
import com.jr.mapper.UserMapper;
import com.jr.service.IRolesService;
import com.jr.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mr.hu
 * @since 2021-11-17
 */
@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles> implements IRolesService {

}
