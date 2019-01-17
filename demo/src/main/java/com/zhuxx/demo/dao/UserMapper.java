package com.zhuxx.demo.dao;

import com.zhuxx.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //方法名和xml中的ID一致
    User findByUserName(String username);
    User deleteByUserName(String username);
    User updateByUserName(String username);
    User findUserByUserName(String username);
    User insertUser(User user);
}
