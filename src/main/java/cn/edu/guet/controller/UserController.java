package cn.edu.guet.controller;

import cn.edu.guet.bean.Permission;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.IUserDao;
import cn.edu.guet.dao.impl.UserDaoImpl;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.IPermissionService;
import cn.edu.guet.service.IUserService;
import cn.edu.guet.service.impl.PermissionServiceImpl;
import cn.edu.guet.service.impl.UserServiceImpl;

import java.util.List;

public class UserController {
    @RequestMapping("/userList")
    public List<User> userList() {
        System.out.println("获取所有的权限");
        IUserService iUserService = new UserServiceImpl();
        System.out.println(iUserService.getUserList());
        return iUserService.getUserList();
    }
}
