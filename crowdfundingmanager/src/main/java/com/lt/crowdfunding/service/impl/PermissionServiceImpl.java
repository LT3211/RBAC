package com.lt.crowdfunding.service.impl;

import com.lt.crowdfunding.bean.Page;
import com.lt.crowdfunding.bean.Permission;
import com.lt.crowdfunding.bean.User;
import com.lt.crowdfunding.dao.PermissionDao;
import com.lt.crowdfunding.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDao permissionDao;

    public Permission queryRootPermission() {
        return permissionDao.queryRootPermission();
    }

    public List<Permission> queryChildPermissions(Integer id) {
        return permissionDao.queryChildPermissions(id);
    }

    public List<Permission> queryAll() {
        return permissionDao.queryAll();
    }

    public void insertPermission(Permission permission) {
        permissionDao.insertPermission(permission);
    }

    public void deletePermission(Permission permission) {
        permissionDao.deletePermission(permission);
    }

    public void updatePermission(Permission permission) {
        permissionDao.updatePermission(permission);
    }

    public Permission queryById(Integer id) {
        return  permissionDao.queryById(id);
    }

    public List<Integer> queryPermissionidsByRoleid(Integer roleid) {
        return permissionDao.queryPermissionidsByRoleid(roleid);
    }

    public List<Permission> queryPermissionsByUser(User dbuser) {
        return permissionDao.queryPermissionsByUser(dbuser);
    }
}
