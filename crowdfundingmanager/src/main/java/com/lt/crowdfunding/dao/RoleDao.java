package com.lt.crowdfunding.dao;

import com.lt.crowdfunding.bean.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    List<Role> pageQueryData(Map<String, Object> map);

    int pageQueryCount(Map<String, Object> map);

    @Select("select * from t_role")
    List<Role> queryAll();

    void deleteRolePermissions(Map<String, Object> paramMap);

    void insertRolePermission(Map<String, Object> paramMap);
}
