package dao.jpa;

import dao.CountryDao;
import model.Country;
import model.simple.SimpleCountry;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

    @Override
    public void save(Country country) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(country);
        transaction.commit();
        em.close();
    }

    @Override
    public List<Country> getAllCountries() {
        EntityManager em = emf.createEntityManager();
        List<? extends Country> countries =
                em.createQuery("from SimpleCountry", SimpleCountry.class)
                        .getResultList();
        em.close();
        return (List<Country>) countries;
    }

    @Override
    public Country getCountryByName(String name) {
        EntityManager em = emf.createEntityManager();
        SimpleCountry country = em
                .createQuery("SELECT c FROM SimpleCountry c WHERE c.name LIKE :name",
                        SimpleCountry.class)
                .setParameter("name", name)
                .getSingleResult();
        em.close();
        return country;
    }

}
