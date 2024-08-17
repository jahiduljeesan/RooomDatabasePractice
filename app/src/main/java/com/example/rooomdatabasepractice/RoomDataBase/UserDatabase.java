package com.example.rooomdatabasepractice.RoomDataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();
    public static volatile UserDatabase userDatabase;

    public static UserDatabase getUserDatabase(Context context) {
        if(userDatabase == null) {
            userDatabase = Room
                    .databaseBuilder(context,UserDatabase.class,"user_database")
                    .allowMainThreadQueries() // for running in main thread;
                    .build();
        }
        return userDatabase;
    }
}
