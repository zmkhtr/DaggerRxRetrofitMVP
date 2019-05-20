package com.sahabat.mvpcompletetutorial.diretrofit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.sahabat.mvpcompletetutorial.R;
import com.sahabat.mvpcompletetutorial.diretrofit.MyApplication;
import com.sahabat.mvpcompletetutorial.diretrofit.adapter.RecyclerViewAdapter;
import com.sahabat.mvpcompletetutorial.diretrofit.di.component.ApplicationComponent;
import com.sahabat.mvpcompletetutorial.diretrofit.di.component.DaggerMainActivityComponent;
import com.sahabat.mvpcompletetutorial.diretrofit.di.component.MainActivityComponent;
import com.sahabat.mvpcompletetutorial.diretrofit.di.module.MainActivityContextModule;
import com.sahabat.mvpcompletetutorial.diretrofit.di.qualifier.ActivityContext;
import com.sahabat.mvpcompletetutorial.diretrofit.di.qualifier.ApplicationContext;
import com.sahabat.mvpcompletetutorial.diretrofit.pojo.StarWars;
import com.sahabat.mvpcompletetutorial.diretrofit.retrofit.APIInterface;
import com.sahabat.mvpcompletetutorial.mvpsimple.MainActivity;

import java.util.List;

import javax.inject.Inject;

public class DiRetrofitActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener {

    private RecyclerView recyclerView;
    MainActivityComponent mainActivityComponent;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;

    @Inject
    public APIInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_di_retrofit);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(DiRetrofitActivity.this));

        ApplicationComponent applicationComponent = MyApplication.get(DiRetrofitActivity.this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);
        recyclerView.setAdapter(recyclerViewAdapter);
        apiInterface.getPeople("json").enqueue(new Callback<StarWars>() {
            @Override
            public void onResponse(Call<StarWars> call, Response<StarWars> response) {
                populateRecyclerView(response.body().results);
            }

            @Override
            public void onFailure(Call<StarWars> call, Throwable t) {

            }
        });

    }

    private void populateRecyclerView(List<StarWars.People> response) {
        recyclerViewAdapter.setData(response);
    }
    @Override
    public void launchIntent(String url) {
        Toast.makeText(mContext, "RecyclerView Row selected", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(activityContext, DetailActivity.class).putExtra("url", url));
    }
}
