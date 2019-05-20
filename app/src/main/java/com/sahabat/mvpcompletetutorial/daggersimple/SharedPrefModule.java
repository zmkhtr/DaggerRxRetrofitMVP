package com.sahabat.mvpcompletetutorial.daggersimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPrefModule {
    private Context mContext;

    public SharedPrefModule(Context context) {
        this.mContext = context;
    }

    @Singleton
    @Provides
    public Context provideContext(){
        return mContext;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
