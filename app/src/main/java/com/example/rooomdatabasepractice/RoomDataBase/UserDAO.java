package com.example.rooomdatabasepractice.RoomDataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

@Dao
public interface UserDAO {

    @Insert
    void insertData(UserEntity user);

    @Delete
    void deletetData(UserEntity user);
}
