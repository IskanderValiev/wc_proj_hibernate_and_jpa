package dao.countriesdao;

import hibernate.WorkWithEntityManger;
import models.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CountriesDaoJpaImpl implements CountriesDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Country findCountryByName(String name) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);

        return (Country) this.entityManager.createQuery("FROM Country country WHERE country.name = :countryName").setParameter("countryName", name).getSingleResult();
    }

    @Override
    public List<Country> findALL() {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);

        return this.entityManager.createQuery("FROM Country country").getResultList();
    }

    @Override
    public String getColumnByName(String columnName, String name) {
        WorkWithEntityManger.ConnectAndTransaction(this.entityManager);
        return (String) this.entityManager.createQuery("SELECT country." + columnName + " FROM Country country WHERE country.name = :name").setParameter("name", name).getSingleResult();
    }

    @Override
    public void save(Country model) {

    }

    @Override
    public Country find(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Country model) {

    }
}
