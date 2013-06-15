package com.wannaride.dataAccess.impl;

import com.wannaride.dataAccess.GenericDAO;
import com.wannaride.entity.Client;
import com.wannaride.entity.Role;
import com.wannaride.entity.TripProvider;
import com.wannaride.entity.User;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/testDataAccessContextInMemoryDB.xml"})
public class GenericDAOImplTestInMemoryDB {

    @Autowired
    @Qualifier("genericDAO")
    private GenericDAO dao;

    @Test
    public void listRolesTest() {
        List<Role> roles = dao.getAll(Role.class);

        for(Role r:roles) System.out.println("role = " + r);

        assertNotNull(roles);
        assertTrue(roles.size() > 0);
    }

    @Test
    public void listUsersTest() {
        List<User> users = dao.getAll(User.class);

        for(User u:users) System.out.println("user = " + u);

        assertNotNull(users);
        assertTrue(users.size() > 0);
    }

    @Ignore
    @Test
    public void listClientsTest() {
        List<Client> clients = dao.getAll(Client.class);

        for(Client c:clients) System.out.println("client = " + c);

        assertNotNull(clients);
        assertTrue(clients.size() > 0);
    }

    @Ignore
    @Test
    public void listTripProvidersTest() {
        List<TripProvider> tripProviders = dao.getAll(TripProvider.class);

        for(TripProvider tp:tripProviders) System.out.println("trip provider = " + tp);

        assertNotNull(tripProviders);
        assertTrue(tripProviders.size() > 0);
    }
}
