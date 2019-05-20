package com.sahabat.mvpcompletetutorial.mvpsimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sahabat.mvpcompletetutorial.R;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private TextView mText;
    private Button mButton;
    private ProgressBar mProgressBar;
    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = findViewById(R.id.textView);
        mButton = findViewById(R.id.button);
        mProgressBar = findViewById(R.id.progressBar);
        presenter = new MainPresenterImpl(this, new GetQuoteInteractorImpl());

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClick();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
        mText.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mText.setVisibility(View.VISIBLE);
    }

    @Override
    public void setQuote(String string) {
        mText.setText(string);
    }
}
