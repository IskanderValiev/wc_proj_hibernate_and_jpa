package services.newsservices;

import dao.newsdao.NewsDao;
import models.News;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    public NewsServiceImpl(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public List<News> getAllNews() {
        return newsDao.getAllNews();
    }

    @Override
    public List<News> getAllArticles() {
        return newsDao.getAllArticles();
    }

    @Override
    public List<News> getAllBlogs() {
        return newsDao.getAllBlogs();
    }

    @Override
    public void addNews(News news) {
        newsDao.save(news);
    }

    @Override
    public List<News> getAll() {
        return newsDao.getAll();
    }
}
