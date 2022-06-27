package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Permission;
import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.IUserDao;
import cn.edu.guet.util.PasswordEncoder;

import java.util.Date;
import java.sql.*;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDaoImpl implements IUserDao {
    @Override
    public User login(String username, String password) {
        Connection conn = null;
        String user = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
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
                    User loginUser = new User();
                    loginUser.setId(rs.getString("userid"));
                    loginUser.setNickName(rs.getString("nick_name"));
                    return loginUser;
                } else {// 密码错了，返回null
                    return null;
                }
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
        return null;
    }

    @Override
    public String getuserid(String username) {
        Connection conn = null;
        String user = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT userid FROM users WHERE username=?;";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String userid = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);// 给占位符赋值
            rs = pstmt.executeQuery();
            // rs.next：游标向下移动
            while (rs.next()) {
                userid = rs.getString("userid");
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
        return userid;
    }

    @Override
    public String getroleid(String rolename) {
        Connection conn = null;
        String user = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT role_id FROM role WHERE role_name=?;";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String roleid = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, rolename);// 给占位符赋值
            rs = pstmt.executeQuery();
            // rs.next：游标向下移动
            while (rs.next()) {
                roleid = rs.getString("role_id");
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
        return roleid;
    }


    @Override
    public List<Permission> getMenuByUserId(String userId) {
        Connection conn = null;
        String user = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT p.*\n" +
                "FROM user_role ur,role_permission rp,permission p\n" +
                "WHERE ur.role_id=rp.role_id\n" +
                "AND rp.permission_id=p.permission_id\n" +
                "AND user_id=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Permission> permissionList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);// 给占位符赋值
            rs = pstmt.executeQuery();
            // rs.next：游标向下移动
            while (rs.next()) {
                Permission permission = new Permission();
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
        } finally {
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
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "select a.userid,a.username,a.nick_name,a.email,a.mobile,a.create_time,c.role_name " +
                "from users a,user_role b,role c " +
                "where a.userid=b.user_id and b.role_id=c.role_id";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> UserList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            // rs.next：游标向下移动
            while (rs.next()) {
                User user1 = new User();
                user1.setId(rs.getString("userid"));
                user1.setUsername(rs.getString("username"));
                user1.setNickName(rs.getString("nick_name"));
                user1.setEmail(rs.getString("email"));
                user1.setMobile(rs.getString("mobile"));
                user1.setCreatetime(rs.getString("create_time"));
                user1.setRolename(rs.getString("role_name"));
                UserList.add(user1);//把芒果放入麻袋
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
        return UserList;//返回集合（把装满芒果的麻袋，扛到车上）
    }

    @Override
    public List<Role> getRoleList() {
        return null;
    }


    @Override
    public boolean adduser(User user) {
        System.out.println("DAO层:" + user);
        String salt = PasswordEncoder.encryptToMD5(user.getUsername());//获取盐
        PasswordEncoder encoderMd5 = new PasswordEncoder(salt, "MD5");
        String pwd_md5 = encoderMd5.encode(user.getPassword());//获取加密后的密码
        Date date = new Date();//获取当前系统时间
        Timestamp create_time = new Timestamp(date.getTime());//
        Connection conn = null;
        String root = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "INSERT INTO users (userid, username, nick_name, password, salt, email, mobile, create_time) VALUES (?,?,?,?,?,?,?,?);";
        String sql2 = "";
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, root, pwd);
            pstmt = conn.prepareStatement(sql);
            // rs.next：游标向下移动
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getNickName());
            pstmt.setString(4, pwd_md5);
            pstmt.setString(5, salt);
            pstmt.setString(6, user.getEmail());
            pstmt.setString(7, user.getMobile());
            pstmt.setTimestamp(8, create_time);
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
    public boolean deleteuser(String username) {
        Connection conn = null;
        String root = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "DELETE FROM users WHERE username = '" + username+"'";
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

    @Override
    public boolean updateuser(User user) {
        System.out.println(user);
        Date date = new Date();//获取当前系统时间
        Timestamp create_time = new Timestamp(date.getTime());//
        Connection conn = null;
        String root = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql2 = "SELECT role_id FROM role WHERE role_name ='"+user.getRolename()+"';";
        String sql3 = "UPDATE users \n" +
                "SET username = ?,nick_name = ?,email = ?,mobile = ? ,create_time = ?\n" +
                "WHERE userid = ?";
        String sql4 = "UPDATE user_role SET role_id = ? WHERE user_id = ?";
        System.out.println(sql2);
        System.out.println(sql3);
        System.out.println(sql4);
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        PreparedStatement pstmt4 = null;
        ResultSet rs2=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, root, pwd);
            pstmt2 = conn.prepareStatement(sql2);
            rs2 = pstmt2.executeQuery();
            assert false;
            String roleid = null;
            while (rs2.next()) {      //这里必须循环遍历
                roleid = rs2.getString("role_id");
                System.out.println(roleid);
            }
            pstmt3 = conn.prepareStatement(sql3);
            pstmt3.setString(1, user.getUsername());
            pstmt3.setString(2, user.getNickName());
            pstmt3.setString(3, user.getEmail());
            pstmt3.setString(4, user.getMobile());
            pstmt3.setTimestamp(5,create_time);
            pstmt3.setString(6, user.getId());

            pstmt3.executeUpdate();
            pstmt4 = conn.prepareStatement(sql4);
            pstmt4.setString(1, roleid);
            pstmt4.setString(2, user.getId());
            pstmt4.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}

