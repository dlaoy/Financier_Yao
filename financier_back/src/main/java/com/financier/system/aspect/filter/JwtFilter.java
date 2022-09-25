//package com.financier.system.aspect.filter;
//
//import com.auth0.jwt.interfaces.Claim;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Map;
//
///**
// * @author enrace
// */
//@WebFilter(filterName = "jwtFilter",urlPatterns = "/secure/*")
//public class JwtFilter implements Filter {
//    private final Logger logger = LoggerFactory.getLogger(JwtFilter.class);
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
//            throws IOException, ServletException {
//        final HttpServletRequest request = (HttpServletRequest) servletRequest;
//        final HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.setCharacterEncoding("UTF-8");
//        String token = request.getHeader("authorization");
//        if("OPTIONS".equals(request.getMethod())) {
//            response.setStatus(HttpServletResponse.SC_OK);
//            filterChain.doFilter(request, response);
//        } else {
//            if(token == null){
//                response.getWriter().write("没有token!");
//                return;
//            }
//        }
//        Map<String, Claim> userData = JwtUtil.verifyToken(token);
//        if(userData == null){
//            response.getWriter().write("token不合法!");
//            return;
//        }
//        Integer id = userData.get("id").asInt();
//        String name = userData.get("userName").asString();
//        request.setAttribute("id",id);
//        request.setAttribute("name",name);
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//    }
//}
