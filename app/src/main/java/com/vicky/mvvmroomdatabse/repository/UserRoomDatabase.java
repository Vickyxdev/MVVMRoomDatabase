package com.vicky.mvvmroomdatabse.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static UserRoomDatabase INSTANCE;

    static UserRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    UserRoomDatabase.class, "user_database")
                    .addCallback(sRoomdatabaseCallback)
                    .build();

        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback sRoomdatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
}
