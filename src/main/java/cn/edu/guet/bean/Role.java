package cn.edu.guet.bean;

import java.util.Objects;

public class Role {


    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getPermissionname() {
        return Permissionname;
    }

    public void setPermissionname(String permissionname) {
        Permissionname = permissionname;
    }

    public String getPermissionid() {
        return Permissionid;
    }

    public void setPermissionid(String permissionid) {
        Permissionid = permissionid;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid='" + roleid + '\'' +
                ", rolename='" + rolename + '\'' +
                ", Permissionname='" + Permissionname + '\'' +
                ", Permissionid='" + Permissionid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleid, role.roleid) && Objects.equals(rolename, role.rolename) && Objects.equals(Permissionname, role.Permissionname) && Objects.equals(Permissionid, role.Permissionid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleid, rolename, Permissionname, Permissionid);
    }

    private String roleid;
    private String rolename;
    private String Permissionname;
    private String Permissionid;
}
