package com.sahabat.mvpcompletetutorial.diretrofit.di.component;

import com.sahabat.mvpcompletetutorial.diretrofit.ui.DetailActivity;
import com.sahabat.mvpcompletetutorial.diretrofit.di.scopes.ActivityScope;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class)
@ActivityScope
public interface DetailActivityComponent {
    void inject(DetailActivity detailActivity);
}
