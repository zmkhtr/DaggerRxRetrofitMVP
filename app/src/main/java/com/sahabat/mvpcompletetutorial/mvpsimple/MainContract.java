package com.sahabat.mvpcompletetutorial.mvpsimple;

public interface MainContract {
    interface MainView {
        void showProgressBar();
        void hideProgressBar();
        void setQuote(String string);
    }

    interface GetQuoteInteractor {
        interface OnFinishedListener {
            void onFinished(String string);
        }
        void getNextQuote(OnFinishedListener onFinishedListener);
    }

    interface Presenter {
        void onButtonClick();
        void onDestroy();
    }
}
