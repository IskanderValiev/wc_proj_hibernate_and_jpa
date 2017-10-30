package dao.usersdao;

import hibernate.HibernateConnector;
import hibernate.WorkWithEntityManger;
import models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UsersDaoJpaImpl implements UsersDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(User model) {
        this.entityManager = HibernateConnector.getConnector().getManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(model);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public User find(Long id) {
        this.entityManager = HibernateConnector.getConnector().getManager();
        this.entityManager.getTransaction().begin();
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(User model) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        this.entityManager.merge(model);
    }

    @Override
    public String getPasswordByLogin(String login) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        return null;
    }

    @Override
    public String getColumnByLogin(String columnName, String login) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        return (String) this.entityManager.createQuery("SELECT user." + columnName + " FROM User user WHERE user.login = :login").setParameter("login", login).getSingleResult();
    }

    @Override
    public String getLoginByEmail(String email) {
        return null;
    }

    @Override
    public boolean exists(String login) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        Query query = this.entityManager.createQuery("SELECT user.id FROM User user WHERE user.login = :login").setParameter("login", login);
        return query.getSingleResult() != null;
    }

    @Override
    public boolean existingEmail(String email) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        Query query = this.entityManager.createQuery("SELECT user.id FROM User user WHERE user.login = :email").setParameter("email", email);
        return query.getSingleResult() != null;
    }

    @Override
    public boolean isAdmin(String login) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        Query query = this.entityManager.createQuery("SELECT user.isAdmin FROM User user WHERE user.login = :login").setParameter("login", login);
        return (Boolean) query.getSingleResult();
    }

    @Override
    public void updateUsersData(String login, String changeableColumnName, String value) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        Query query = this.entityManager.createQuery("UPDATE User SET " + changeableColumnName + " =:newValue WHERE login = :login");
        query.setParameter("newValue", value);
        query.setParameter("login", login);
    }

    @Override
    public String getLoginByPassword(String password) {
        return null;
    }


}
