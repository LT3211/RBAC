package com.lt.crowdfunding.service;

import com.lt.crowdfunding.bean.Permission;
import com.lt.crowdfunding.bean.User;

import java.util.List;

public interface PermissionService {
    Permission queryRootPermission();

    List<Permission> queryChildPermissions(Integer id);

    List<Permission> queryAll();

    void insertPermission(Permission permission);

    void deletePermission(Permission permission);

    void updatePermission(Permission permission);

    Permission queryById(Integer id);

    List<Integer> queryPermissionidsByRoleid(Integer roleid);

    List<Permission> queryPermissionsByUser(User dbuser);
}
