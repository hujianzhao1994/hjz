package com.jr.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jr.util.CustomStringStringConverter;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mr.hu
 * @since 2022-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ExcelProperty(index = 0,value = "ID")
    private Integer id;

    @ExcelProperty(index = 1,value = "姓名")
    private String name;

    @ExcelProperty(index = 2,value ="性别",converter = CustomStringStringConverter.class)
    private Integer sex;

    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(index = 3, value = "生日")
    private Date created;


}
