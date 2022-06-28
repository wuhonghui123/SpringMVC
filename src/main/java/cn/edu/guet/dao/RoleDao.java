package cn.edu.guet.dao;

import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.User;

import java.util.List;

public interface RoleDao {
    void adduserrole(User user);
    boolean deleteuserrole(String username);
    List<Role> getRoleList();
    List<Role> getRolePermissionList();
}
