package laji;

import com.itheima.pojo.yonghu;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "user1Servlet", value = "/ddd")
public class User1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        /*mybatis*/
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        yonghu select = mapper.select(name, passwd);
        sqlSession.close();
        //*判断*//*
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (select != null)
            writer.write("登录成功");
        else
            writer.write("登录失败");
        writer.write("11111111111111");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String resourceq = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resourceq);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<yonghu> yonghus = mapper.find();
        /*for (yonghu a :
                yonghus) {
            System.out.println(a.getId() + a.getPasswd() + a.getUesrr());
        }*/
        sqlSession.close();
        PrintWriter writer = response.getWriter();
        writer.write("sfsf");
    }
}
