package com.itheima.mapper;


import com.itheima.pojo.yonghu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    yonghu select(@Param("name") String name, @Param("passwd") String passwd);

    List<yonghu> find();

    yonghu regselect(String uesrr);

    void add(yonghu yonghu);
}
