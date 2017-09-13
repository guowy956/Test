//package com.cn.filter;
//
//import com.cn.swagger2.API.SuccessModel;
//import com.cn.util.JsonMapper;
//import com.cn.util.security.jwt.JwtHelper;
//import io.jsonwebtoken.Claims;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.context.support.SpringBeanAutowiringSupport;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 拦截器 - 备用
// *
// * @author guowy
// * @create 2017-06-08 10:10
// **/
//
//public class LoginInterceptor implements Filter {
//
//    @Value("${jwt.sec}")
//    private String JWT_SEC;
//    @Value("${jwt.tokenName}")
//    private String JWT_TOKEN_NAME;
//    @Value("${login.useFilter}")
//    private boolean LOGIN_USE_FILTER;
//
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
//                filterConfig.getServletContext());
//    }
//
//    /**
//     * 从request中获取token，验证是否已登录
//     *      已登录条件：  token不为空，token没有过期
//     *      未登录：    返回401
//     * @param servletRequest
//     * @param servletResponse
//     * @param filterChain
//     * @throws IOException
//     * @throws ServletException
//     */
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
//        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
//        response.setHeader("Content-type", "text/html;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//
//        //登录过滤器，使用
//        if(LOGIN_USE_FILTER){
//            boolean isLogin = false;
//            String token = servletRequest.getParameter(JWT_TOKEN_NAME);
//            if(StringUtils.isNotBlank(token)){
//                Claims claims = JwtHelper.parseJWT(token,JWT_SEC);
//                // 没有过期
//                if(claims != null){
//                    isLogin = true;
//                }
//            }
//            if(isLogin){ //已登录
//                filterChain.doFilter(servletRequest,servletResponse);
//            }else{
//                SuccessModel successModel = new SuccessModel();
//                successModel.setCode(401);
//                successModel.setMessage("登录失败");
//                successModel.setData("");
//                response.getWriter().write(JsonMapper.nonDefaultMapper().toJson(successModel));
//            }
//            // 登录过滤器，不使用
//        }else{
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}