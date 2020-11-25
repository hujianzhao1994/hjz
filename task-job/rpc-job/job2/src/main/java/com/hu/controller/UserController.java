

package com.hu.controller;
import com.hu.domain.User;
import com.hu.domain.vo.UserVO;
import com.hu.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/user")
public class UserController {
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userSvc;

    @ApiOperation(value = "创建用户", notes="private")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userVO", value = "UserVO", required = true, dataType = "UserVO", paramType = "body")
    })
    @PostMapping(value = "/users", produces = "application/json;charset=UTF-8")
    public User createUser( @RequestBody UserVO userVO) {
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        userSvc.save(user);
        return user;
    }

    @ApiOperation(value = "按用户id删除", notes="private")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", defaultValue = "2", value = "userID", required = true, dataType = "string", paramType = "path"),
    })
    @DeleteMapping(value = "/users/{userId}", produces = "application/json;charset=UTF-8")
    public User delUser(@PathVariable String userId) {
        User user = (User)userSvc.deleteById(userId);
        log.info("rest del user={} by id={}", user, userId);
        return user;
    }

    @ApiOperation(value = "查询所有用户")
    @GetMapping(value = "/users", produces = "application/json;charset=UTF-8")
    public Iterable<User> findAllUsers() {
        Collection<User> users = userSvc.getAllUsers();
        log.info("rest get all users");
        return users;
    }


    @Value("${spring.profiles.active}")
    private  String envName;

    @ApiOperation(value = "查询所有用户")
    @GetMapping(value = "/env", produces = "application/json;charset=UTF-8")
    public Object env() {
        return envName;
    }


}