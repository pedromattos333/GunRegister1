package com.senac.pedro.gunregister.dao.helper;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public class DaoHelper<T> {
    protected Dao<T, Integer> dao;
    protected Class classname;
    public static ORMLiteHelper mInstance = null;

    public DaoHelper(Context c, Class classname){
        this.classname = classname;
        if (mInstance==null) mInstance = new ORMLiteHelper(c.getApplicationContext());
    }

    public Dao<T, Integer> getDao() {
        try {
            return mInstance.getDao(classname);
        } catch (SQLException e) {
            return null;
        }
    }
}