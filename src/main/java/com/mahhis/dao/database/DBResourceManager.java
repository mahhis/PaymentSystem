package com.mahhis.dao.database;

import java.util.ResourceBundle;

public final class DBResourceManager {
    private final static DBResourceManager instance = new DBResourceManager();

    private final ResourceBundle bundle = ResourceBundle.getBundle(DBParameter.DB);

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }
}
