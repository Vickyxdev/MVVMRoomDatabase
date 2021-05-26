package com.vicky.mvvmroomdatabse.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.vicky.mvvmroomdatabse.repository.User;
import com.vicky.mvvmroomdatabse.repository.UserRopository;

import java.util.List;

public class UserListViewModel extends AndroidViewModel {

    private UserRopository userRopository;
    private LiveData<List<User>> mAllUser;

    public UserListViewModel(Application application) {
        super(application);
        userRopository = new UserRopository(application);
        mAllUser = userRopository.getmAllUsers();

    }

    public LiveData<List<User>> getmAllUser(){
        return mAllUser;
    }

    public void insert(User user){
        userRopository.insert(user);
    }
}
