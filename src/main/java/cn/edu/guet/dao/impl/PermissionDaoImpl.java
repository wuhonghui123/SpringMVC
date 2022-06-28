package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Permission;
import cn.edu.guet.dao.IPermissionDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PermissionDaoImpl implements IPermissionDao {
    @Override
    public List<Permission> permissionList() {
        Connection conn = null;
        String user = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT * FROM permission";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Permission> permissionList=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            // rs.next：游标向下移动
            while(rs.next()){
                Permission permission=new Permission();
                permission.setId(rs.getString("permission_id"));
                permission.setpId(rs.getString("pid"));
                permission.setName(rs.getString("permission_name"));
                permission.setUrl(rs.getString("url"));
                permission.setIcon(rs.getString("icon"));
                permission.setTarget(rs.getString("target"));
                permission.setIsParent(rs.getString("isParent"));

                permissionList.add(permission);//把芒果放入麻袋
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return permissionList;//返回集合（把装满芒果的麻袋，扛到车上）
    }

    @Override
    public boolean addpermission(Permission permission) {
        Connection conn = null;
        String root = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "INSERT INTO permission (permission_id, pid, permission_name, url, icon, target, isParent) VALUES (?,?,?,?,?,?,?);";
        String sql2 = "SELECT permission_id FROM permission WHERE permission_name = ?";
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        String pid = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, root, pwd);
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, permission.getpId());// 给占位符赋值
            rs = pstmt2.executeQuery();
            // rs.next：游标向下移动
            while (rs.next()) {
                pid = rs.getString("permission_id");
            }
            pstmt = conn.prepareStatement(sql);
            // rs.next：游标向下移动
            pstmt.setString(1, permission.getId());
            pstmt.setString(2, pid);
            pstmt.setString(3, permission.getName());
            pstmt.setString(4, permission.getUrl());
            pstmt.setString(5, permission.getIcon());
            pstmt.setString(6, permission.getTarget());
            pstmt.setString(7, permission.getIsParent());
            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                pstmt2.close();
                conn.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @Override
    public boolean updatepermission(Permission permission) {
        Connection conn = null;
        String root = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "UPDATE permission \n" +
                "SET permission_name = ?,url = ?,icon = ?" +
                "WHERE permission_id = ?";
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, root, pwd);
            pstmt = conn.prepareStatement(sql);
            // rs.next：游标向下移动
            pstmt.setString(1, permission.getName());
            pstmt.setString(2, permission.getUrl());
            pstmt.setString(3, permission.getIcon());
            pstmt.setString(4, permission.getId());
            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @Override
    public boolean deletepermission(String permissionname) {
        Connection conn = null;
        String root = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "DELETE FROM permission WHERE permission_name = '" + permissionname+"'";
        int row;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, root, pwd);
            Statement s = conn.createStatement();
            row = s.executeUpdate(sql);
            //6. 关闭连接，释放资源
            conn.close();
            s.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return row != 0;
    }
}
