package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Permission;
import cn.edu.guet.dao.IPermissionDao;
import cn.edu.guet.dao.impl.PermissionDaoImpl;
import cn.edu.guet.service.IPermissionService;

import java.util.List;

public class PermissionServiceImpl implements IPermissionService {
    @Override
    public List<Permission> permissionList() {
        IPermissionDao permissionDao=new PermissionDaoImpl();

        return permissionDao.permissionList();
    }

    @Override
    public boolean addpermission(Permission permission) {
        IPermissionDao permissionDao=new PermissionDaoImpl();
        return permissionDao.addpermission(permission);
    }

    @Override
    public boolean updatepermission(Permission permission) {
        IPermissionDao permissionDao=new PermissionDaoImpl();
        return permissionDao.updatepermission(permission);
    }

    @Override
    public boolean deletepermission(String permissionname) {
        IPermissionDao permissionDao=new PermissionDaoImpl();
        return permissionDao.deletepermission(permissionname);
    }

}
