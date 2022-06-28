package cn.edu.guet.controller;

import cn.edu.guet.bean.Permission;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.IPermissionService;
import cn.edu.guet.service.impl.PermissionServiceImpl;

import java.util.List;

@Controller
public class PermissionController {
    @RequestMapping("/permissionList")
    public List<Permission> permissionList() {
        System.out.println("获取所有的权限");
        IPermissionService permissionService = new PermissionServiceImpl();

        return permissionService.permissionList();
    }
    @RequestMapping("/addpermission")
    public boolean addpermission(String permissionname,String url,String icon,String target,String isParent,String pidname){
        Permission permission = new Permission();
        permission.setName(permissionname);
        permission.setUrl(url);
        permission.setIcon(icon);
        permission.setTarget(target);
        permission.setIsParent(isParent);
        permission.setpId(pidname);
        System.out.println(permission);
        return true;
    }
    @RequestMapping("/updatepermission")
    public boolean updatepermission(String permissionname,String url,String icon,String permissionid){
        Permission permission = new Permission();
        permission.setName(permissionname);
        permission.setUrl(url);
        permission.setIcon(icon);
        permission.setId(permissionid);
        System.out.println(permission);
        return true;
    }

}
