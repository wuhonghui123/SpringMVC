package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Loopimg;
import cn.edu.guet.bean.News;
import cn.edu.guet.dao.LoopimgDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoopimgDaoImpl implements LoopimgDao {
    @Override
    public List<Loopimg> getloopimgList() {
        Connection conn = null;
        String user = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT * FROM loopimg ORDER BY updatetime DESC LIMIT 0,1000";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Loopimg> loopimgList=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            // rs.next：游标向下移动
            while(rs.next()){
                Loopimg loopimg = new Loopimg();
                loopimg.setLoopimgurl(rs.getString("loopimgurl"));
                loopimg.setLoopimgid(rs.getString("loopimgid"));

                loopimgList.add(loopimg);//把芒果放入麻袋
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
        return loopimgList;//返回集合（把装满芒果的麻袋，扛到车上）
    }
}
