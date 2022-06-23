package cn.edu.guet.bean;

import java.util.Objects;

public class News {






    public String getNews_class() {
        return news_class;
    }

    public void setNews_class(String news_class) {
        this.news_class = news_class;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getNews_image() {
        return news_image;
    }

    public void setNews_image(String news_image) {
        this.news_image = news_image;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getNews_url() {
        return news_url;
    }

    public void setNews_url(String news_url) {
        this.news_url = news_url;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(news_class, news.news_class) && Objects.equals(news_title, news.news_title) && Objects.equals(news_content, news.news_content) && Objects.equals(news_image, news.news_image) && Objects.equals(update_time, news.update_time) && Objects.equals(news_url, news.news_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(news_class, news_title, news_content, news_image, update_time, news_url);
    }


    @Override
    public String toString() {
        return "News{" +
                "news_class='" + news_class + '\'' +
                ", news_title='" + news_title + '\'' +
                ", news_content='" + news_content + '\'' +
                ", news_image='" + news_image + '\'' +
                ", update_time='" + update_time + '\'' +
                ", news_url='" + news_url + '\'' +
                '}';
    }
    private String news_class;
    private String news_title;
    private String news_content;
    private String news_image;
    private String update_time;
    private String news_url;
}
