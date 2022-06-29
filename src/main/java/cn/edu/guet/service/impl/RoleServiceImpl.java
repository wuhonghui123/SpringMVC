package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.RoleDao;
import cn.edu.guet.dao.impl.RoleDaoImpl;
import cn.edu.guet.service.RoleService;

import java.util.List;
import java.util.UUID;

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

    @Override
    public boolean updaterole(String roleid, String rolename, String roleinfor) {
        int a = (roleinfor.length()+1)/33;
        System.out.println("菜单个数"+a);
        String[] result = roleinfor.split(",");
        for(String r : result){
            System.out.println("分割结果" + r);
        }
        for(int i = 0;i<a;i++){
            System.out.println(result[i]);
        }
        RoleDao roleDao = new RoleDaoImpl();
        boolean b = roleDao.deleterolePermission(roleid);
        for(int i = 0;i<a;i++){
            roleDao.addrolePermission(roleid,result[i]);
        }
        return b;
    }

    @Override
    public boolean addrole(String rolename, String roleinfor) {
        int a = (roleinfor.length()+1)/33;
        System.out.println("菜单个数"+a);
        String[] result = roleinfor.split(",");
        for(String r : result){
            System.out.println("分割结果" + r);
        }
        for(int i = 0;i<a;i++){
            System.out.println(result[i]);
        }
        String roleid = UUID.randomUUID().toString().replace("-","");
        RoleDao roleDao = new RoleDaoImpl();
        boolean b = roleDao.addrole(rolename,roleid);
        for(int i = 0;i<a;i++){
            roleDao.addrolePermission(roleid,result[i]);
        }
        return b;
    }

    @Override
    public boolean deleterole(String roleid) {
        RoleDao roleDao = new RoleDaoImpl();
        roleDao.deleterolePermission(roleid);
        roleDao.deleteuserroletwo(roleid);
        return roleDao.deleterole(roleid);
    }
}
