package com.lyh.mapper;

import com.lyh.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 卢宇航
 * @Description
 * @create 2021-04-28 10:20
 */
public interface UserMapper {
//    @Insert("INSERT  INTO user(id,name,pwd) VALUES (#{id},#{name},#{pwd})")
    public void  addUser(User users);

    public List<User> selectUser();

    public void delUserById(int id);

    public void updateUserById(User users);
}
