package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.News;
import cn.edu.guet.dao.NewsDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl implements NewsDao {
    @Override
    public List<News> newsList() {
        Connection conn = null;
        String user = "root";// mysql的用户名
        String pwd = "123456";
        String url = "jdbc:mysql://127.0.0.1:3306/guet?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT * FROM news ORDER BY update_time DESC LIMIT 0,1000";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<News> newsList=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            // rs.next：游标向下移动
            while(rs.next()){
                News news = new News();
                news.setNews_class(rs.getString("news_class"));
                news.setNews_title(rs.getString("news_title"));
                news.setNews_content(rs.getString("news_content"));
                news.setNews_image(rs.getString("news_image"));
                news.setUpdate_time(rs.getString("update_time"));
                news.setNews_url(rs.getString("news_url"));

                newsList.add(news);//把芒果放入麻袋
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
        return newsList;//返回集合（把装满芒果的麻袋，扛到车上）
    }
}
