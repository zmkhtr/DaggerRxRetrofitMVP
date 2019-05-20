package com.sahabat.mvpcompletetutorial.diretrofit.di.module;

import com.sahabat.mvpcompletetutorial.diretrofit.adapter.RecyclerViewAdapter;
import com.sahabat.mvpcompletetutorial.diretrofit.di.scopes.ActivityScope;
import com.sahabat.mvpcompletetutorial.diretrofit.ui.DiRetrofitActivity;
import com.sahabat.mvpcompletetutorial.mvpsimple.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getStarWarsPeopleList(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(DiRetrofitActivity mainActivity) {
        return mainActivity;
    }
}
