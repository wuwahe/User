package laji;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name = "ServletTest", value = "/a")
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html;charset=utf-8");
        boolean flag = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie c :
                    cookies) {
                    String name = c.getName();
                    if ("lastTime".equals(name)) {
                        flag = true;
                        String value = c.getValue();
                        response.getWriter().write("欢迎回来，你上次访问时间为" + value);
                        Date date = new  Date();
                        SimpleDateFormat sf = new SimpleDateFormat("yyyy年mm月dd日HH:mm:ss");
                        String time = sf.format(date);
                        c.setValue(time);
                        c.setMaxAge(60*60*24*30);
                        response.addCookie(c);
                    }

            }

        }
        if(cookies ==null || cookies.length == 0 || flag == false){
            Date date = new  Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy年mm月dd日HH:mm:ss");
            String time = sf.format(date);
            Cookie cookie = new Cookie("lastTime",time);
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
            response.getWriter().write("欢迎首次访问");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
