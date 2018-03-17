package de.android.ayrathairullin.vkclient.mvp.view;


import com.arellomobile.mvp.MvpView;

import de.android.ayrathairullin.vkclient.model.WallItem;
import de.android.ayrathairullin.vkclient.model.view.counter.LikeCounterViewModel;

public interface PostFooterView extends MvpView {
    void like(LikeCounterViewModel likes);

    void openComments(WallItem wallItem);
}
