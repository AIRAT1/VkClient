package de.android.ayrathairullin.vkclient.mvp.view;


import com.arellomobile.mvp.MvpView;

import de.android.ayrathairullin.vkclient.model.Profile;
import de.android.ayrathairullin.vkclient.ui.fragment.BaseFragment;

public interface MainView extends MvpView{
    void startSignIn();
    void signedIn();
    void showCurrentUser(Profile profile);
    void showFragmentFromDrawer(BaseFragment baseFragment);
}
