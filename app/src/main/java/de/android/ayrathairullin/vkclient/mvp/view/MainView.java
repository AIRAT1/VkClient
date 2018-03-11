package de.android.ayrathairullin.vkclient.mvp.view;


import com.arellomobile.mvp.MvpView;

import de.android.ayrathairullin.vkclient.model.Profile;

public interface MainView extends MvpView{
    void startSignIn();
    void signedIn();
    void showCurrentUser(Profile profile);
}
