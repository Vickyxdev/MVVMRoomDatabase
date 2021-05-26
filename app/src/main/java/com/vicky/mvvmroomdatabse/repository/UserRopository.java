package com.vicky.mvvmroomdatabse.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRopository {
    private UserDao userDao;
    LiveData<List<User>> mAllUsers;

    public UserRopository(Application application){
        UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
        userDao = db.userDao();
        mAllUsers = userDao.getAllUsers();

    }

    public LiveData<List<User>> getmAllUsers(){
        return mAllUsers;
    }

    public void insert(User user){
        new insertAsyncTask(userDao).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao userDaoAync;

        public insertAsyncTask(UserDao userDao) {

            userDaoAync = userDao;
        }

        @Override
        protected Void doInBackground(final User... voids) {
            userDaoAync.insert(voids[0]);
            return null;
        }
    }
}
