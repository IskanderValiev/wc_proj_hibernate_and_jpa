package dao.newsdao;

import hibernate.HibernateConnector;
import hibernate.WorkWithEntityManger;
import models.News;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class NewsDaoJpaImpl implements NewsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<News> getAllNews() {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        Query query = this.entityManager.createQuery("SELECT news FROM News news WHERE news.type = 'News'");
        return query.getResultList();
    }

    @Override
    public List<News> getAllArticles() {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        Query query = this.entityManager.createQuery("SELECT news FROM News news WHERE news.type = 'Article'");
        return query.getResultList();
    }

    @Override
    public List<News> getAllBlogs() {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        Query query = this.entityManager.createQuery("SELECT news FROM News news WHERE news.type = 'Blog'");
        return query.getResultList();
    }

    @Override
    public void save(News model) {
        this.entityManager = HibernateConnector.getConnector().getManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(model);
    }

    @Override
    public List<News> getAll() {
        this.entityManager = HibernateConnector.getConnector().getManager();
        this.entityManager.getTransaction().begin();
        return this.entityManager.createQuery("SELECT news FROM News news").getResultList();
    }

    @Override
    public News find(Long id) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        return this.entityManager.find(News.class, id);
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public void update(News model) {
    }
}
