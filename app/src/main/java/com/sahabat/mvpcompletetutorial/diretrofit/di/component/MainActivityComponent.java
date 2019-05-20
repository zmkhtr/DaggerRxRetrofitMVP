package com.sahabat.mvpcompletetutorial.diretrofit.di.component;

import android.content.Context;

import com.sahabat.mvpcompletetutorial.diretrofit.ui.DiRetrofitActivity;
import com.sahabat.mvpcompletetutorial.diretrofit.di.module.AdapterModule;
import com.sahabat.mvpcompletetutorial.diretrofit.di.qualifier.ActivityContext;
import com.sahabat.mvpcompletetutorial.diretrofit.di.scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = AdapterModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {
    @ActivityContext
    Context getContext();

    void injectMainActivity(DiRetrofitActivity mainActivity);
}
