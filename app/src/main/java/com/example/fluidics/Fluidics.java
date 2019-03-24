package com.example.fluidics;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.fluidics.models.DBFluidics;
import com.facebook.stetho.Stetho;

public class Fluidics extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        DBFluidics.db = Room
                .databaseBuilder(
                        this,
                        DBFluidics.class,
                        "Fluidics.db"
                )
                .fallbackToDestructiveMigration()
                .build();
    }
}
