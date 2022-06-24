package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Permission;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.IUserDao;
import cn.edu.guet.util.PasswordEncoder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public User login(String username, String password) {
        Connection conn = null;
        String user = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://127.0.0.1:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT userid,nick_name,password,salt FROM users WHERE username=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);// 给占位符赋值
            rs = pstmt.executeQuery();
            if (rs.next()) {
                // 如果满足这个条件，说明什么？说明：用户名是正确的
                String encPass = rs.getString("password");
                String salt = rs.getString("salt");

                PasswordEncoder encoderMd5 = new PasswordEncoder(salt, "MD5");
                boolean result = encoderMd5.matches(encPass, password);
                // result如果是真，说明密码也正确
                if (result) {
                    User loginUser=new User();
                    loginUser.setId(rs.getString("userid"));
                    loginUser.setNickName(rs.getString("nick_name"));
                    return  loginUser;
                } else {// 密码错了，返回null
                    return null;
                }
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
        return  null;
    }

    @Override
    public List<Permission> getMenuByUserId(String userId) {
        Connection conn = null;
        String user = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://127.0.0.1:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT p.*\n" +
                "FROM user_role ur,role_permission rp,permission p\n" +
                "WHERE ur.role_id=rp.role_id\n" +
                "AND rp.permission_id=p.permission_id\n" +
                "AND user_id=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Permission> permissionList=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);// 给占位符赋值
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


    //获取用户列表
    @Override
    public List<User> getUserList() {
        Connection conn = null;
        String user = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://127.0.0.1:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "select a.userid,a.username,a.nick_name,a.email,a.mobile,a.create_time,c.role_name " +
                "from users a,user_role b,role c " +
                "where a.userid=b.user_id and b.role_id=c.role_id";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> UserList=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            // rs.next：游标向下移动
            while(rs.next()){
                User user1 = new User();
                user1.setUsername(rs.getString("username"));
                user1.setNickName(rs.getString("nick_name"));
                user1.setEmail(rs.getString("email"));
                user1.setMobile(rs.getString("mobile"));
                user1.setCreatetime(rs.getString("create_time"));
                user1.setRolename(rs.getString("role_name"));

                UserList.add(user1);//把芒果放入麻袋
                System.out.println(user1);
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
        return UserList;//返回集合（把装满芒果的麻袋，扛到车上）
    }
}
