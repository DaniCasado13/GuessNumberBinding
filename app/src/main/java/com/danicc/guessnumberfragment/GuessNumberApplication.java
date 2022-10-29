package com.danicc.guessnumberfragment;

import android.app.Application;

import com.danicc.guessnumberfragment.data.Juego;

public class GuessNumberApplication extends Application {

    private Juego juego;
    public Juego getJuego() {
        return juego;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        juego=new Juego("Dani",7);
    }
}
