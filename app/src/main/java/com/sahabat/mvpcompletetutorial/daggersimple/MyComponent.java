package com.sahabat.mvpcompletetutorial.daggersimple;


import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {SharedPrefModule.class})
public interface MyComponent {
    void inject(DaggerActivity activity);
}
