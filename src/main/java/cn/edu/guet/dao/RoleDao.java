package cn.edu.guet.dao;

import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.User;

import java.util.List;

public interface RoleDao {
    void adduserrole(User user);
    boolean deleteuserrole(String username);
    boolean deleteuserroletwo(String roleid);
    List<Role> getRoleList();
    List<Role> getRolePermissionList();
    boolean addrole(String rolename,String roleid);
    boolean deleterole(String roleid);
    void addrolePermission(String roleid,String permissionid);
    boolean deleterolePermission(String roleid);
}
