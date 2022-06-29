package cn.edu.guet.service;

import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.User;

import java.util.List;

public interface RoleService {
    void adduserrole(User user);
    boolean deleteuserrole(String username);
    List<Role> getRoleList();
    List<Role> getRolePermissionList();
    boolean updaterole(String roleid,String rolename,String roleinfor);
    boolean addrole(String rolename,String roleinfor);
    boolean deleterole(String roleid);
}
