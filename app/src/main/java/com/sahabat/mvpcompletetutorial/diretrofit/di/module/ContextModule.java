package com.sahabat.mvpcompletetutorial.diretrofit.di.module;

import android.content.Context;

import com.sahabat.mvpcompletetutorial.diretrofit.di.qualifier.ApplicationContext;
import com.sahabat.mvpcompletetutorial.diretrofit.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext(){
        return context;
    }
}
