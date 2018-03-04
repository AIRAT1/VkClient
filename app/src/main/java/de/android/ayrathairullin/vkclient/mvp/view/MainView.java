package de.android.ayrathairullin.vkclient.mvp.view;


import com.arellomobile.mvp.MvpView;

public interface MainView extends MvpView{
    void startSignIn();
    void signedIn();
}
