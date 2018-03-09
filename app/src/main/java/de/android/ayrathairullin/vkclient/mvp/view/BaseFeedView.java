package de.android.ayrathairullin.vkclient.mvp.view;


import com.arellomobile.mvp.MvpView;

public interface BaseFeedView extends MvpView{
    void showRefreshing();
    void hideRefreshing();
}
