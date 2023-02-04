package com.itheima.servelet;

import com.itheima.pojo.yonghu;
import com.itheima.service.loginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private loginService loginService = new loginService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html;charset=utf-8");
        yonghu login = loginService.login(username, password);
        if (login != null){
            HttpSession session = request.getSession();
            session.setAttribute("name",login);
            request.getRequestDispatcher("/a").forward(request,response);
        }else {
            request.setAttribute("reg_msg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
