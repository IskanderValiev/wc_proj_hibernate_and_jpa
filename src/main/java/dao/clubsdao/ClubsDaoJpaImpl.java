package dao.clubsdao;

import hibernate.WorkWithEntityManger;
import models.Club;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ClubsDaoJpaImpl implements ClubsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String getLogo(String clubName) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        return (String) this.entityManager.createQuery("SELECT club.logo FROM Club club WHERE club.name = :clubName").setParameter("clubName", clubName).getSingleResult();
    }

    @Override
    public void save(Club model) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        this.entityManager.persist(model);
    }

    @Override
    public Club find(Long id) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        return this.entityManager.find(Club.class, id);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Club model) {

    }
}
