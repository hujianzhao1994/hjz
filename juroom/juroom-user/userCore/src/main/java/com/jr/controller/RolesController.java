package com.jr.controller;


import com.jr.base.BaseController;
import com.jr.entity.Roles;
import com.jr.service.IRolesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mr.hu
 * @since 2021-11-17
 */
@RestController
@RequestMapping("/roles")
@Slf4j
public class RolesController extends BaseController {


    @Autowired
    private IRolesService iRolesService;

    @GetMapping("/list")
    public Object list(){
        List<Roles> list = iRolesService.list();
        log.info("list----->{}",list.toString());
        return  list;
    }

}

