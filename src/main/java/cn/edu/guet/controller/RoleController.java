package cn.edu.guet.controller;

import cn.edu.guet.bean.Role;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.RoleService;
import cn.edu.guet.service.impl.RoleServiceImpl;

import java.sql.Array;
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
    @RequestMapping("/updaterole")
    public boolean updaterole(String roleid,String rolename,String roleinfor){
        RoleService roleService = new RoleServiceImpl();
        return roleService.updaterole(roleid,rolename,roleinfor);
    }
    @RequestMapping("/addrole")
    public boolean addrole(String rolename,String roleinfor){
        RoleService roleService = new RoleServiceImpl();
        return roleService.addrole(rolename,roleinfor);
    }

    @RequestMapping("/deleterole")
    public boolean deleterole(String roleid){
        RoleService roleService = new RoleServiceImpl();
        return roleService.deleterole(roleid);
    }
}
