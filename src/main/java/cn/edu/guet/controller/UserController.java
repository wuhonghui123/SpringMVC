package cn.edu.guet.controller;

import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.User;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.IUserService;
import cn.edu.guet.service.RoleService;
import cn.edu.guet.service.impl.RoleServiceImpl;
import cn.edu.guet.service.impl.UserServiceImpl;

import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @RequestMapping("/userList")
    public List<User> userList() {
        System.out.println("获取所有的用户");
        IUserService iUserService = new UserServiceImpl();
        return iUserService.getUserList();
    }
    @RequestMapping("/Adduser")
    public boolean adduser(String username,String password,String nickname,String rolename,String email,String mobile){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickName(nickname);
        user.setRolename(rolename);
        user.setEmail(email);
        user.setMobile(mobile);
        user.setId(UUID.randomUUID().toString().replace("-",""));//获取随机ID);
        IUserService userService = new UserServiceImpl();
        RoleService roleService = new RoleServiceImpl();
        boolean a = userService.adduser(user);
        roleService.adduserrole(user);
        System.out.println("添加用户 "+user+" 成功:");
        return a;
    }
    @RequestMapping("/deleteuser")
    public boolean deleteuser(String username){
        RoleService roleService = new RoleServiceImpl();
        boolean a = roleService.deleteuserrole(username);
        System.out.println("删除用户的角色成功"+username);
        IUserService userService = new UserServiceImpl();
        boolean b = userService.deleteuser(username);
        System.out.println("删除用户成功"+username);
        return a&&b;
    }
    @RequestMapping("/updateuser")
    public boolean updateuser(String userid,String username,String nickname,String rolename,String email,String mobile){
        User user = new User();
        user.setId(userid);
        user.setUsername(username);
        user.setNickName(nickname);
        user.setRolename(rolename);
        user.setEmail(email);
        user.setMobile(mobile);
        IUserService userService = new UserServiceImpl();
        System.out.println("修改用户信息");
        return userService.updateuser(user);
    }
}
