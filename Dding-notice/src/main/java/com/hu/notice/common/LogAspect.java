package com.hu.notice.common;

import com.hu.notice.utils.DingTalkUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Slf4j
@Aspect
public class LogAspect {

    @Pointcut("execution(public * com.hu.notice.web..*.*(..))")
    public void requestAspect(){
    }


    @Before(value = "requestAspect()")
    public void methodBefore(JoinPoint joinPoint){
    }


    @Autowired
    Environment environment;

    @AfterThrowing(pointcut="requestAspect()",throwing = "ex")
    public void afterThrowable(JoinPoint joinPoint,Throwable ex) throws Exception {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        log.info("【接口地址】：{}",request.getRequestURL().toString());
        log.info("【请求头】：{}", request.getHeaderNames());
        log.info("【接口参数】：{}", Arrays.toString(joinPoint.getArgs()));
        log.info("【请求ip】 - {}",request.getRemoteAddr());
        log.info("【请求方式】 - {}" ,request.getMethod());
        log.info("【方法全路径】 - {}",joinPoint.getSignature());
        log.info("【类名】 - {}",joinPoint.getTarget().getClass());
        log.info("【方法名】 - {}",joinPoint.getSignature().getName());
        log.info("【请求类方法参数】- {}" ,Arrays.toString(joinPoint.getArgs()));



        StringBuilder sb = new StringBuilder("工程名：\n"+environment.getProperty("spring.application.name")).append("\n\n");
        sb.append("【接口地址】：\n"+request.getRequestURL().toString()).append("\n\n");
        sb.append("【请求头】：\n"+ request.getHeaderNames()).append("\n\n");
        sb.append("【接口参数】：\n"+ Arrays.toString(joinPoint.getArgs())).append("\n\n");
        sb.append("【请求ip】 - \n"+request.getRemoteAddr()).append("\n\n");
        sb.append("【请求方式】 - \n"+request.getMethod()).append("\n\n");
        sb.append("【方法全路径】 - \n"+joinPoint.getSignature()).append("\n\n");
        sb.append("【类名】 - \n"+joinPoint.getTarget().getClass()).append("\n\n");
        sb.append("【方法名】 - \n"+joinPoint.getSignature().getName()).append("\n\n");
        sb.append("【请求类方法参数】- \n"+Arrays.toString(joinPoint.getArgs())).append("\n\n");

        if(null != ex && null != ex.getStackTrace()){
            sb.append("【异常信息】：").append("\n");
            StackTraceElement[] stackTrace = ex.getStackTrace();
            for (int i = 0; i < 5; i++) {
                sb.append(stackTrace[i]).append("\n");
            }
        }

        DingTalkUtils.notice(null,sb.toString());
        log.error("切面发生了异常：", ex);

    }

}
