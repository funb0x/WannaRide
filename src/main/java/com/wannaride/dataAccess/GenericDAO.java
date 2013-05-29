package com.wannaride.dataAccess;

import java.util.List;

public interface GenericDAO {

    public <T> void create(T newInstance);

    public <T> T read(Class<T> type, int id);

    public <T> void update(T transientObject);

    public <T> void delete(T persistentObject);

    public <T> List<T> getAll(Class<T> type);

    public <T> int count(Class<T> type);

}
