package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/wode.jsp")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest rep = (HttpServletRequest) request;
        HttpSession session = rep.getSession();
        Object name = session.getAttribute("name");
        if (name != null) {
            chain.doFilter(request, response);
        }else {
            request.setAttribute("reg_msg","请先登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
