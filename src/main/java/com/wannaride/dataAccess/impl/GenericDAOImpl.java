package com.wannaride.dataAccess.impl;

import com.wannaride.dataAccess.GenericDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("genericDAO")
public class GenericDAOImpl implements GenericDAO {

    @PersistenceContext
    protected EntityManager em;

    protected void setEm(EntityManager em){
        this.em = em;
    }

    @Transactional
    public <T> void create(T newInstance) {
        em.persist(newInstance);
    }

    @Transactional(readOnly = true)
    public <T> T read(Class<T> type, int id) {
        return em.find(type, id);
    }

    @Transactional
    public <T> void update(T transientObject) {
        em.merge(transientObject);
    }

    @Transactional
    public <T> void delete(T persistentObject) {
        em.remove(em.merge(persistentObject));
    }

    @Transactional(readOnly = true)
    public <T> List<T> getAll(Class<T> type) {

        Query query = em.createQuery("SELECT s FROM " + type.getSimpleName() + " s", type);

        return query.getResultList();
    }

    @Transactional
    public <T> int count(Class<T> type) {
        return getAll(type).size();
    }

}
