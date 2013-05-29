package com.wannaride.dataAccess.impl;

import com.wannaride.dataAccess.UserDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Repository("userDAO")
public class UserDAOImpl extends GenericDAOImpl implements UserDAO {
    @Override
    public boolean chekLoginAvailability(String login) {
        Query query = em.createNativeQuery("SELECT count(*) FROM users where login = ?1");
        query.setParameter(1, login);

        List<Object[]> resultList = query.getResultList();
        Object o = resultList.get(0);
        BigInteger number = (BigInteger) o;

        return number.intValue() == 0;
    }

    @Override
    public boolean chekEmailAvailability(String email) {
        Query query = em.createNativeQuery("SELECT count(*) FROM users where email = ?1");
        query.setParameter(1, email);

        List<Object[]> resultList = query.getResultList();
        Object o = resultList.get(0);
        BigInteger number = (BigInteger) o;

        return number.intValue() == 0;
    }
}
