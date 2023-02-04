package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.yonghu;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class loginService {
    public yonghu login(String name,String passwd){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        yonghu select = mapper.select(name, passwd);
        sqlSession.close();
        return select;
    }
    public boolean zhuce(yonghu yonghu){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        yonghu regselect = mapper.regselect(yonghu.getUesrr());
        if (regselect == null){
            mapper.add(yonghu);
            sqlSession.commit();
        }
        sqlSession.close();
        return regselect == null;
    }
}
