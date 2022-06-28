package cn.edu.guet.service;

import cn.edu.guet.bean.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> permissionList();
    boolean addpermission(Permission permission);
    boolean updatepermission(Permission permission);
    boolean deletepermission(String permissionname);
}
