package cn.edu.guet.service.impl;

import cn.edu.guet.bean.News;
import cn.edu.guet.dao.NewsDao;
import cn.edu.guet.dao.impl.NewsDaoImpl;
import cn.edu.guet.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    @Override
    public List<News> newsList() {
        NewsDao newsDao = new NewsDaoImpl();
        return newsDao.newsList();
    }
}
