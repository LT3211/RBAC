package com.lt.crowdfunding.dao;

import com.lt.crowdfunding.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface UserDao {

    @Select("select * from t_user")
    List<User> queryAll();

    @Select("select * from t_user where loginacct=#{loginacct} and userpswd =#{userpswd}")
    User query4Login(User user);

    List<User> pageQueryData(Map<String, Object> map);

    int pageQueryCount(Map<String, Object> map);

    void insertUser(User user);

    @Select("select * from t_user where id=#{id}")
    User queryById(Integer id);

    void updateUser(User user);

    @Delete("delete  from t_user where id=#{id}")
    void deleteUserById(Integer id);

    void deleteUsers(Map<String, Object> map);

    void insertUserRoles(Map<String, Object> map);

    void deleteUserRoles(Map<String, Object> map);

    @Select("select roleid from t_user_role where userid=#{userid}")
    List<Integer> queryRoleidsByUserid(Integer id);
}
