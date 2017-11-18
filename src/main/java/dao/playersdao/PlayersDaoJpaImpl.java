package dao.playersdao;

import hibernate.WorkWithEntityManger;
import models.Club;
import models.Player;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PlayersDaoJpaImpl implements PlayersDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Player> findAllByClub(Integer clubId) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);

        Query query = this.entityManager.createQuery("FROM Player player WHERE player.club = :id").setParameter("id", clubId);
        return query.getResultList();
    }

    @Override
    public List<Player> findAllByCountry(Integer countryId) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);

        Query query = this.entityManager.createQuery("SELECT player FROM Player player WHERE player.country = :countryid").setParameter("countryid", countryId);
        return query.getResultList();
    }

    @Override
    public String getClub(Player player) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        Query query = this.entityManager.createQuery("SELECT player.club FROM Player player WHERE player.name = :playerName AND player.country = :playerCountry");
        query.setParameter("playerName", player.getName());
        query.setParameter("playerCountry", player.getCountry());
        Club club = (Club) query.getSingleResult();
        return club.getName();
    }

    @Override
    public String getColumnByName(String columnName, String name) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        Query query = this.entityManager.createQuery("SELECT player." + columnName + " FROM Player player WHERE player.name = :name AND player.lastname = :lastname");
        query.setParameter("name", name);
        return (String) query.getSingleResult();
    }

    @Override
    public void save(Player model) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        this.entityManager.persist(model);
    }

    @Override
    public Player find(Long id) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        return this.entityManager.find(Player.class, id);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Player model) {

    }
}
