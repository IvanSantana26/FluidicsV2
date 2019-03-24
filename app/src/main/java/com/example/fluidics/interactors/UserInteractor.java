package com.example.fluidics.interactors;

import android.annotation.SuppressLint;

import com.example.fluidics.models.DBFluidics;
import com.example.fluidics.models.dao.UserDao;
import com.example.fluidics.models.entities.Usuario;
import com.example.fluidics.utils.callback.CBDone;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserInteractor {
    private static UserInteractor instance;

    public static UserInteractor getInstance() {
        if (instance == null) {
            instance = new UserInteractor();
        }
        return instance;
    }

    @SuppressLint("CheckResult")
    public void seedUsuers(CBDone cb) {
        Single.fromCallable(
                () -> {
                    Usuario u1 = new Usuario();
                    u1.setNombre("Miguel");
                    u1.setApellido_materno("Flores");
                    u1.setApellido_paterno("Colin");
                    u1.setEmail("maiktmp@gmail.com");
                    u1.setPassword("14280487");
                    UserDao userDao = DBFluidics.db.userDao();
                    userDao.upsert(u1);
                    return u1;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (u1) -> cb.done()
                );
    }
}
