package de.android.ayrathairullin.vkclient.mvp.view;


import com.arellomobile.mvp.MvpView;

import java.util.List;

import de.android.ayrathairullin.vkclient.model.view.BaseViewModel;

public interface BaseFeedView extends MvpView{
    void showRefreshing();
    void hideRefreshing();
    void showListProgress();
    void hideListProgress();
    void showError(String message);
    void setItems(List<BaseViewModel> items);
    void addItems(List<BaseViewModel> items);

}
