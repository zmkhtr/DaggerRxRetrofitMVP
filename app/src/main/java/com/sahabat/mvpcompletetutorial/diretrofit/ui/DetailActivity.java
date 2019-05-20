package com.sahabat.mvpcompletetutorial.diretrofit.ui;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.sahabat.mvpcompletetutorial.R;
import com.sahabat.mvpcompletetutorial.diretrofit.MyApplication;
import com.sahabat.mvpcompletetutorial.diretrofit.di.component.ApplicationComponent;
import com.sahabat.mvpcompletetutorial.diretrofit.di.component.DaggerDetailActivityComponent;
import com.sahabat.mvpcompletetutorial.diretrofit.di.component.DetailActivityComponent;
import com.sahabat.mvpcompletetutorial.diretrofit.di.qualifier.ApplicationContext;
import com.sahabat.mvpcompletetutorial.diretrofit.pojo.Film;
import com.sahabat.mvpcompletetutorial.diretrofit.retrofit.APIInterface;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity {

    DetailActivityComponent detailActivityComponent;

    @Inject
    public APIInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context mContext;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView = findViewById(R.id.textView);
        String url = getIntent().getStringExtra("url");

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        detailActivityComponent = DaggerDetailActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .build();

        detailActivityComponent.inject(this);

        apiInterface.getFilmData(url, "json").enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                Film films = response.body();
                String text = "Film name:\n" + films.title + "\nDirector:\n" + films.director;
                textView.setText(text);
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });
    }
}
