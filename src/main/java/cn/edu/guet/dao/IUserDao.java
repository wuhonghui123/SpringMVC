package cn.edu.guet.dao;


import cn.edu.guet.bean.Permission;
import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.User;

import java.util.List;

public interface IUserDao {

    User login(String username, String password);
    String getuserid(String username);
    String getroleid(String rolename);
    List<Permission> getMenuByUserId(String userId);
    List<User> getUserList();
    List<Role> getRoleList();
    boolean adduser(User user);
    boolean deleteuser(String username);
    boolean updateuser(User user);
}
