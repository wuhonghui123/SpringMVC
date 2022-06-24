package cn.edu.guet.controller;

import cn.edu.guet.bean.User;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.IUserService;
import cn.edu.guet.service.impl.UserServiceImpl;

import java.util.List;
@Controller
public class UserController {
    @RequestMapping("/userList")
    public List<User> userList() {
        System.out.println("获取所有的用户");
        IUserService iUserService = new UserServiceImpl();
        System.out.println(iUserService.getUserList());
        return iUserService.getUserList();
    }
}
