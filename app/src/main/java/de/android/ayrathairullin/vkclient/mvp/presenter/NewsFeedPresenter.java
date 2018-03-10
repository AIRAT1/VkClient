package de.android.ayrathairullin.vkclient.mvp.presenter;


import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.android.ayrathairullin.vkclient.MyApplication;
import de.android.ayrathairullin.vkclient.common.utils.VkListHelper;
import de.android.ayrathairullin.vkclient.model.view.BaseViewModel;
import de.android.ayrathairullin.vkclient.model.view.NewsItemBodyViewModel;
import de.android.ayrathairullin.vkclient.model.view.NewsItemFooterViewModel;
import de.android.ayrathairullin.vkclient.model.view.NewsItemHeaderViewModel;
import de.android.ayrathairullin.vkclient.mvp.view.BaseFeedView;
import de.android.ayrathairullin.vkclient.rest.api.WallApi;
import de.android.ayrathairullin.vkclient.rest.model.request.WallGetRequestModel;
import io.reactivex.Observable;

@InjectViewState
public class NewsFeedPresenter extends BaseFeedPresenter<BaseFeedView>{
    @Inject
    WallApi mWallApi;

    public NewsFeedPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return mWallApi.get(new WallGetRequestModel(-1090630, count, offset).toMap())
                .flatMap(full -> Observable.fromIterable(VkListHelper.getWallList(full.response)))
                .flatMap(wallItem -> {
                    List<BaseViewModel> baseItems = new ArrayList<>();
                    baseItems.add(new NewsItemHeaderViewModel(wallItem));
                    baseItems.add(new NewsItemBodyViewModel(wallItem));
                    baseItems.add(new NewsItemFooterViewModel(wallItem));
                    return Observable.fromIterable(baseItems);
                });
    }
}
