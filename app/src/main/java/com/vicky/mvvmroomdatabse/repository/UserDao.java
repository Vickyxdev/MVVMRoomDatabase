package com.vicky.mvvmroomdatabse.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("SELECT * from userInfo ORDER BY user_name ASC")
    LiveData<List<User>> getAllUsers();
    
    @Query("DELETE from userInfo")
    void deleteAll();
}
