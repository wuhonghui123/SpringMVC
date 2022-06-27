package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.RoleDao;
import cn.edu.guet.dao.impl.RoleDaoImpl;
import cn.edu.guet.service.RoleService;

public class RoleServiceImpl implements RoleService {
    @Override
    public void adduserrole(User user) {
        RoleDao roleDao = new RoleDaoImpl();
        roleDao.adduserrole(user);
    }

    @Override
    public boolean deleteuserrole(String username) {
        System.out.println("服务层:"+username);
        RoleDao roleDao = new RoleDaoImpl();
        return roleDao.deleteuserrole(username);
    }
}
