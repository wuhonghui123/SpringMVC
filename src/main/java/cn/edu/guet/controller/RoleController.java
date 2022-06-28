package cn.edu.guet.controller;

import cn.edu.guet.bean.Role;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.RoleService;
import cn.edu.guet.service.impl.RoleServiceImpl;

import java.util.List;
@Controller
public class RoleController {
    @RequestMapping("/roleList")
    public List<Role> roleList(){
        RoleService roleService = new RoleServiceImpl();
        return roleService.getRoleList();
    }
    @RequestMapping("/rolePermissionList")
    public List<Role> rolePermissionList(){
        RoleService roleService = new RoleServiceImpl();
        return roleService.getRolePermissionList();
    }
}
