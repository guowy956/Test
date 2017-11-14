package com.cn.filter;

import com.cn.swagger2.API.SuccessModel;
import com.cn.util.JsonMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 *
 * @author guowy
 * @create 2017-06-08 10:10
 **/

public class SecurityInterceptor implements HandlerInterceptor {

    @Value("${login.userFilter}")
    private boolean LOGIN_USER_FILTER;

    @Value("${jwt.sec}")
    private String JWT_SEC;

    @Value("${jwt.tokenName}")
    private String JWT_TOKEN_NAME;

    private final String API = "/api";

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        //验证用户是否登陆
        Object obj = request.getSession().getAttribute(API);


        String token  =  "accessToken";
        boolean isLogin  = false;
        String parameter = request.getParameter(token);

        System.out.println();
        if (StringUtils.isNotBlank(parameter)) {
            if(parameter.equals("null")){
                isLogin = true;
            }
        }
        if (isLogin) {
            SuccessModel successModel = new SuccessModel();
            successModel.setCode(401);
            successModel.setMessage("登录失败");
            successModel.setData("");
            response.getWriter().write(JsonMapper.nonDefaultMapper().toJson(successModel));
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}
