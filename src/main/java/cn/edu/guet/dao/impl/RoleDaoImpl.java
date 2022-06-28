package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Permission;
import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.RoleDao;
import cn.edu.guet.util.PasswordEncoder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @Override
    public void adduserrole(User user) {
        Connection conn = null;
        String root = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "INSERT INTO user_role(user_id,role_id)VALUES(?," +
                "(SELECT a.xx from\n" +
                "(SELECT role_id xx from role where role_name = ?)as a\n" +
                "));";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, root, pwd);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getId());// 给占位符赋值
            pstmt.setString(2, user.getRolename());
            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteuserrole(String username) {
        Connection conn = null;
        String root = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "DELETE FROM user_role WHERE user_id in (SELECT userid FROM users WHERE username = '" + username + "');";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, root, pwd);
            Statement s = conn.createStatement();
            int row = s.executeUpdate(sql);
            //6. 关闭连接，释放资源
            conn.close();
            s.close();
            return row!=0;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Role> getRoleList() {
        Connection conn = null;
        String user = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT * FROM role";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Role> roleList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            // rs.next：游标向下移动
            while (rs.next()) {
                Role role = new Role();
                role.setRoleid(rs.getString("role_id"));
                role.setRolename(rs.getString("role_name"));
                roleList.add(role);//把芒果放入麻袋
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return roleList;//返回集合（把装满芒果的麻袋，扛到车上）
    }

    @Override
    public List<Role> getRolePermissionList() {
        Connection conn = null;
        String user = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT r.role_id,r.role_name,p.permission_name,p.permission_id \n" +
                "from role r,permission p,role_permission rp\n" +
                "WHERE r.role_id= rp.role_id\n" +
                "AND p.permission_id = rp.permission_id";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Role> roleList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            // rs.next：游标向下移动
            while (rs.next()) {
                Role role = new Role();
                role.setRoleid(rs.getString("role_id"));
                role.setRolename(rs.getString("role_name"));
                role.setPermissionid(rs.getString("permission_id"));
                role.setPermissionname(rs.getString("permission_name"));
                roleList.add(role);//把芒果放入麻袋
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return roleList;//返回集合（把装满芒果的麻袋，扛到车上）
    }
}
