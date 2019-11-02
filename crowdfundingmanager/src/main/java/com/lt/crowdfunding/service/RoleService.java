package com.lt.crowdfunding.service;

import com.lt.crowdfunding.bean.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    List<Role> pageQueryData(Map<String, Object> map);

    int pageQueryCount(Map<String, Object> map);

    List<Role> queryAll();

    void insertRolePermission(Map<String, Object> paramMap);
}
