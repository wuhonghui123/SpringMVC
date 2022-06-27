package cn.edu.guet.service;

import cn.edu.guet.bean.User;

public interface RoleService {
    void adduserrole(User user);
    boolean deleteuserrole(String username);
}
