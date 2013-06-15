package com.wannaride.dataAccess;

public interface UserDAO extends GenericDAO {

    boolean chekLoginAvailability(String login);

    boolean chekEmailAvailability(String email);

}