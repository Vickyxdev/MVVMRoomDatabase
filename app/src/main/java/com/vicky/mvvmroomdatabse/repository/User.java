package com.vicky.mvvmroomdatabse.repository;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userInfo")
public class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user_name")
    private String userName;

    @NonNull
    @ColumnInfo(name = "user_designation")
    private String userDesignation;

    public User(@NonNull String userName, @NonNull String userDesignation) {
        this.userName = userName;
        this.userDesignation = userDesignation;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    @NonNull
    public String getUserDesignation() {
        return userDesignation;
    }

    public void setUserDesignation(@NonNull String userDesignation) {
        this.userDesignation = userDesignation;
    }
}
