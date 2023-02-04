import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.itheima.pojo.yonghu;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class test {
    @Test
    public  void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<yonghu> yonghus = mapper.find();
        for (yonghu a:
             yonghus) {
            System.out.println(a.getId() + a.getPasswd() + a.getUesrr());
        }
        sqlSession.close();
    }
    @Test
    public  void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        yonghu y = mapper.select("2633712201","abc66666");
        System.out.println(y);
        sqlSession.close();
    }
    @Test
    public  void testadd() throws IOException {
        yonghu yonghu = new yonghu();
        yonghu.setUesrr("12345655");
        yonghu.setPasswd("1111a11a1");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.add(yonghu);
        sqlSession.close();
    }
    @Test
    public void tttttt(){
        Date date = new  Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年mm月dd日HH:mm:ss");
        String format = sf.format(date);
        System.out.println(format);
    }
}
