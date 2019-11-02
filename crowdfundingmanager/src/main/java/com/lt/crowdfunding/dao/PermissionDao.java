package com.lt.crowdfunding.dao;

import com.lt.crowdfunding.bean.Permission;
import com.lt.crowdfunding.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    @Select("select * from t_permission where pid is null")
    Permission queryRootPermission();

    @Select("select * from t_permission where pid=#{id}")
    List<Permission> queryChildPermissions(Integer id);

    @Select("select * from t_permission")
    List<Permission> queryAll();

    void insertPermission(Permission permission);

    void deletePermission(Permission permission);

    void updatePermission(Permission permission);

    @Select("select * from t_permission where id=#{id}")
    Permission queryById(Integer id);

    @Select("select permissionid from t_role_permission where roleid=#{roleid}")
    List<Integer> queryPermissionidsByRoleid(Integer roleid);

    List<Permission> queryPermissionsByUser(User dbuser);
}
