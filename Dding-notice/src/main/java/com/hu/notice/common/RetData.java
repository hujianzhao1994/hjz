package com.hu.notice.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

/**
 * @param <T>
 * @author hujz
 * @Description: 接口返回公共模型
 * @date 2017年10月27日 下午6:37:55
 */
@JsonInclude(Include.NON_NULL)
@Data
public class RetData<T> {

    private Integer code = 0; // 0=成功 ，1 失败，...
    private String msg ; // 返回信息

    private T data; // 返回模型


    /**
     * 分页数据的总条数
     */
    private Long total_count;

    /**
     * 错误的堆栈信息，用于调试，生产环境需要关闭调试
     */
    private String error_stack_trace;
    /**
     * 接口请求参数，用于调试，生产环境需要关闭调试
     */
    private Object request_parameter;
    /**
     * 接口消耗时间
     */
    private long elapsed_time;

    private long timestamp = System.currentTimeMillis();


    public RetData() {
        super();
    }

    public RetData(T data) {
        super();
        this.data = data;
    }

    public RetData(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public RetData(Integer code, T data) {
        super();
        this.code = code;
        this.data = data;
    }

    public RetData(Integer code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RetData ok(){
        RetData retData = new RetData();
        retData.setCode(0);
        retData.setMsg("成功");
        return retData;
    }

    public RetData ok(T data){
        RetData retData = new RetData();
        retData.setCode(0);
        retData.setMsg("成功");
        retData.setData(data);
        return retData;
    }

}
