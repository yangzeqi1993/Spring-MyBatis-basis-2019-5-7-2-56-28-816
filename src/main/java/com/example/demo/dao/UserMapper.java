package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    // 1. 实现查询所有用户
    @Select("select * from user_address_info")
    List<User> findAll();

    // 2. 根据用户id查询用户
    @Select("select * from user_address_info where id = #{id}")
    User findById(Integer id);

    // 3. 添加新用户
    // 返回的Integer值是变化的行数，@Options()会填充到实体 user 中。
    @Insert("insert into user_address_info(id, name, phone, address) value(#{id}, #{name}, #{phone}, #{address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(User user);

    // 4. 根据用户id删除用户
    @Delete("delete from user_address_info where id = #{id}")
    void deleteUser(Integer id);

    // 5. 根据用户id更新用户
    @Update("update user_address_info set name = #{name}, phone = #{phone}, address = #{address} where id = #{id}")
    void updateUser(User user);

}
