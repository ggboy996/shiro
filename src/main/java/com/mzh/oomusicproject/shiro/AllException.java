package com.mzh.oomusicproject.shiro;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class AllException {
    /// 角色權权限异常捕捉
    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public void roleException(UnauthorizedException e, HttpServletResponse response) throws IOException {
        System.out.println("---------------------->" + e);
        response.sendRedirect("/noPermission");
    }


    // 其它异常异常捕捉
    @ExceptionHandler(value = Exception.class)
    @ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public String allException(Exception e) {
        System.out.println("---------------------->" + e);
        return "系統出现异常！！！";
    }
}
