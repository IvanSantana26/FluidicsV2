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
                    UserDao userDao = DBFluidics.db.userDao();

                    Usuario u1 = new Usuario();
                    Usuario u2 = new Usuario();
                    Usuario u3 = new Usuario();
                    Usuario u4 = new Usuario();
                    Usuario u5= new Usuario();
                    Usuario u6 = new Usuario();


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
