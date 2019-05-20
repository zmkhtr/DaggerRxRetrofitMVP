package com.sahabat.mvpcompletetutorial.diretrofit.di.component;


import android.content.Context;

import com.sahabat.mvpcompletetutorial.diretrofit.retrofit.APIInterface;
import com.sahabat.mvpcompletetutorial.diretrofit.MyApplication;
import com.sahabat.mvpcompletetutorial.diretrofit.di.module.ContextModule;
import com.sahabat.mvpcompletetutorial.diretrofit.di.module.RetrofitModule;
import com.sahabat.mvpcompletetutorial.diretrofit.di.qualifier.ApplicationContext;
import com.sahabat.mvpcompletetutorial.diretrofit.di.scopes.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {
    APIInterface getApiInterface();

    @ApplicationContext
    Context getContext();

    void injectApplication(MyApplication myApplication);
}
