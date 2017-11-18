//package dao.commentsdao;
//
//import hibernate.HibernateConnector;
//import models.Comment;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//public class CommentsDaoJpaImpl implements CommentsDao {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public void save(Comment model) {
//        this.entityManager = HibernateConnector.getConnector().getManager();
//        this.entityManager.getTransaction();
//        this.entityManager.persist(model);
//    }
//
//    @Override
//    public Comment find(Long id) {
//        this.entityManager = HibernateConnector.getConnector().getManager();
//        this.entityManager.getTransaction();
//        return this.entityManager.find(Comment.class, id);
//    }
//
//    @Override
//    public void delete(Long id) {
//        this.entityManager = HibernateConnector.getConnector().getManager();
//        this.entityManager.getTransaction();
//        this.entityManager.createQuery("delete from Comment comment where comment.id = :id").setParameter("id", id);
//    }
//
//    @Override
//    public void update(Comment model) {
//        this.entityManager = HibernateConnector.getConnector().getManager();
//        this.entityManager.getTransaction();
//        this.entityManager.merge(model);
//    }
//}
