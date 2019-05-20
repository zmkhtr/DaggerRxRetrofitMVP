package com.sahabat.mvpcompletetutorial.diretrofit.di.module;

import android.content.Context;

import com.sahabat.mvpcompletetutorial.diretrofit.ui.DiRetrofitActivity;
import com.sahabat.mvpcompletetutorial.diretrofit.di.qualifier.ActivityContext;
import com.sahabat.mvpcompletetutorial.diretrofit.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {
    private DiRetrofitActivity mainActivity;

    public Context context;

    public MainActivityContextModule(DiRetrofitActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public DiRetrofitActivity ProvidesMainActivity(){
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }
}
