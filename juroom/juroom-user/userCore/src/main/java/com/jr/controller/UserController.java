package com.jr.controller;

import com.alibaba.excel.EasyExcel;
import com.jr.base.BaseController;
import com.jr.entity.User;
import com.jr.entity.UserData;
import com.jr.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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
        user.setCreated(new Date());

        boolean save = iUserService.save(user);
        log.info("【save】 obj="+user.getId());
        
        return "ok";

    }


    @GetMapping("/getUser")
    public Object getUser(){
        List<User> list = iUserService.list();
        // 实现excel写操作
        //1.设置写入文件夹地址和excel文件名称
        String fileName = "D:\\write.xlsx";
        //调用easyExcel里面的方法实现写操作
        //2个参数，第一个参数是文件名称，第二个参数是实体类
        EasyExcel.write(fileName, UserData.class).sheet("学生信息表").doWrite(list);
        return list;
    }

}

