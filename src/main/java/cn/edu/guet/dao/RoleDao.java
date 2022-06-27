package cn.edu.guet.dao;

import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.User;

public interface RoleDao {
    void adduserrole(User user);
    boolean deleteuserrole(String username);
}
