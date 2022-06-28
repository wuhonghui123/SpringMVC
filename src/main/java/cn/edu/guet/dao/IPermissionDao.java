package cn.edu.guet.dao;

import cn.edu.guet.bean.Permission;

import java.util.List;

public interface IPermissionDao {
    List<Permission> permissionList();
    boolean addpermission(Permission permission);
    boolean updatepermission(Permission permission);
    boolean deletepermission(String permissionname);
}
