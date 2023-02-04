package com.itheima.servelet;

import com.itheima.pojo.yonghu;
import com.itheima.service.loginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
     loginService loginService = new loginService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String checkCodesion = (String) session.getAttribute("checkCode");
        if (!checkCodesion.equals(checkCode)) {
            request.setAttribute("reg_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }

        yonghu yonghu = new yonghu();
        yonghu.setUesrr(username);
        yonghu.setPasswd(password);

        boolean zhuce = loginService.zhuce(yonghu);
        if (zhuce){
            request.setAttribute("reg_msg","注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            request.setAttribute("reg_msg","用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
