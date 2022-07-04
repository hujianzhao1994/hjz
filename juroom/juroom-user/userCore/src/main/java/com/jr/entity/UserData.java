package com.jr.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserData implements Serializable {


    @ExcelProperty(index = 0,value = "ID")
    private  Integer id;

    @ExcelProperty(index = 1,value = "姓名")
    private  String name;

    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(index = 2, value = "生日")
    private Date created;
}
