package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.RoleDao;
import cn.edu.guet.dao.impl.RoleDaoImpl;
import cn.edu.guet.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Override
    public void adduserrole(User user) {
        RoleDao roleDao = new RoleDaoImpl();
        roleDao.adduserrole(user);
    }

    @Override
    public boolean deleteuserrole(String username) {
        RoleDao roleDao = new RoleDaoImpl();
        return roleDao.deleteuserrole(username);
    }

    @Override
    public List<Role> getRoleList() {
        RoleDao roleDao = new RoleDaoImpl();
        return roleDao.getRoleList();
    }

    @Override
    public List<Role> getRolePermissionList() {
        RoleDao roleDao = new RoleDaoImpl();
        return roleDao.getRolePermissionList();
    }
}
