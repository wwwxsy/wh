package com.kagami.j2ee.common;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value="/*")
public class CodecFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        // 统一处理请求和响应的字符编码问题
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        // 或是servletResponse.setContentType("text/html;charset=utf-8");
        //过滤完之后需要放行请求和响应
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
