package hibernate;

import javax.persistence.EntityManager;

public class WorkWithEntityManger {

    public static void ConnectAndTransaction(EntityManager entityManager) {
        entityManager = HibernateConnector.getConnector().getManager();
        entityManager.getTransaction().begin();
    }
}
