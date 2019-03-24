package com.example.fluidics.models.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.fluidics.models.entities.Usuario;

@Dao
public interface UserDao {

    /**
     * Get user from database
     */
    @Query("SELECT * FROM Usuario WHERE id = :id")
    Usuario findById(long id);

    @Query("SELECT * FROM Usuario WHERE email = :email")
    Usuario findByEmail(String email);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long upsert(Usuario usuario);

}
