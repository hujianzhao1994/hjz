package com.jr.controller;

import com.alibaba.excel.EasyExcel;
import com.jr.base.BaseController;
import com.jr.entity.User;
import com.jr.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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


    /**
     *      web 下载
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("/getUser")
    public Object getUser(HttpServletResponse response) throws IOException {

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=demo.xlsx");
        List<User> list = iUserService.list();
        EasyExcel.write(response.getOutputStream(), User.class).sheet("模板").doWrite(list);
        return null;
    }

}

