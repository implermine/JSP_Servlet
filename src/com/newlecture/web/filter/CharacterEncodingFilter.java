package com.newlecture.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

//        System.out.println("before filter");
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
//        System.out.println("after filter");
    }

    @Override
    public void destroy() {

    }
}
