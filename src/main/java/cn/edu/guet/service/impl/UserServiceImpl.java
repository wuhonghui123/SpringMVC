package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Permission;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.IUserDao;
import cn.edu.guet.dao.RoleDao;
import cn.edu.guet.dao.impl.RoleDaoImpl;
import cn.edu.guet.dao.impl.UserDaoImpl;
import cn.edu.guet.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public class UserServiceImpl implements IUserService {

    @Override
    public User login(String username, String password) {
        IUserDao userDao = new UserDaoImpl();
        return userDao.login(username, password);

    }

    @Override
    public List<Permission> getMenuByUserId(String userId) {
        IUserDao userDao = new UserDaoImpl();
        return userDao.getMenuByUserId(userId);
    }

    @Override
    public List<User> getUserList() {
        IUserDao userDao = new UserDaoImpl();
        return userDao.getUserList();
    }

    @Override
    public boolean adduser(User user) {
        IUserDao userDao = new UserDaoImpl();
        return userDao.adduser(user);
    }

    @Override
    public boolean deleteuser(String username) {
        IUserDao userDao = new UserDaoImpl();
        return userDao.deleteuser(username);
    }

    @Override
    public boolean updateuser(User user) {
        IUserDao userDao = new UserDaoImpl();
        String roleid = userDao.getroleid(user.getRolename());
        user.setRoleid(roleid);
        return userDao.updateuser(user);
    }
}
