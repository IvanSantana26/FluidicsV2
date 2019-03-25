package com.example.fluidics.models;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.fluidics.models.dao.UserDao;
import com.example.fluidics.models.entities.Usuario;


@Database(entities = {
        Usuario.class,
},
        version = 2,
        exportSchema = false

)

public abstract class DBFluidics extends RoomDatabase {
    public static DBFluidics db;

    public abstract UserDao userDao();
}


