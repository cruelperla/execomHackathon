package com.rza.exhackathonapp.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.orm.SugarApp;
import com.orm.SugarDb;

/**
 * Created by Rza on 22-May-17.
 */

public class MyApp extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Fresco.initialize(this);
    }
}
