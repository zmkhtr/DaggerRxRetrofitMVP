package com.sahabat.mvpcompletetutorial.mvpsimple;

public class MainPresenterImpl implements MainContract.Presenter,MainContract.GetQuoteInteractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetQuoteInteractor getQuoteInteractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetQuoteInteractor getQuoteInteractor) {
        this.mainView = mainView;
        this.getQuoteInteractor = getQuoteInteractor;
    }

    @Override
    public void onFinished(String string) {
        if (mainView != null) {
            mainView.setQuote(string);
            mainView.hideProgressBar();
        }
    }

    @Override
    public void onButtonClick() {
        if (mainView != null) {
            mainView.showProgressBar();
        }
        getQuoteInteractor.getNextQuote(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

}
