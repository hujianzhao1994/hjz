package com.jr.controller;

import com.jr.base.BaseController;
import com.jr.entity.User;
import com.jr.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mr.hu
 * @since 2022-05-09
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/save")
    public Object saveUser(){
        User user = new User();
        user.setName("user");
        user.setCreated(LocalDateTime.now());

        boolean save = iUserService.save(user);
        log.info("【save】 obj="+user.getId());
        
        return "ok";

    }

}

