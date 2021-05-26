package com.vicky.mvvmroomdatabse.repository;

import android.os.AsyncTask;

public class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final UserDao userDao;

    public PopulateDbAsync(UserRoomDatabase db) {
        userDao = db.userDao();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        userDao.deleteAll();


        return null;
    }
}
