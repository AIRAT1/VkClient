package de.android.ayrathairullin.vkclient.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.android.ayrathairullin.vkclient.MyApplication;
import de.android.ayrathairullin.vkclient.R;
import de.android.ayrathairullin.vkclient.common.utils.VkListHelper;
import de.android.ayrathairullin.vkclient.model.WallItem;
import de.android.ayrathairullin.vkclient.model.view.BaseViewModel;
import de.android.ayrathairullin.vkclient.model.view.NewsItemBodyViewModel;
import de.android.ayrathairullin.vkclient.model.view.NewsItemFooterViewModel;
import de.android.ayrathairullin.vkclient.model.view.NewsItemHeaderViewModel;
import de.android.ayrathairullin.vkclient.rest.api.WallApi;
import de.android.ayrathairullin.vkclient.rest.model.request.WallGetRequestModel;
import de.android.ayrathairullin.vkclient.rest.model.response.GetWallResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class NewsFeedFragment extends BaseFeedFragment {
    @Inject
    WallApi mWallApi;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWallApi.get(new WallGetRequestModel(-1090630).toMap()).flatMap(new Function<GetWallResponse, ObservableSource<WallItem>>() {
            @Override
            public ObservableSource<WallItem> apply(@NonNull GetWallResponse getWallResponse) throws Exception {
                return Observable.fromIterable(VkListHelper.getWallList(getWallResponse.response));
            }
        })
                .flatMap(new Function<WallItem, ObservableSource<BaseViewModel>>() {
                    @Override
                    public ObservableSource<BaseViewModel> apply(@NonNull WallItem wallItem) throws Exception {
                        List<BaseViewModel> baseItems = new ArrayList<>();
                        baseItems.add(new NewsItemHeaderViewModel(wallItem));
                        baseItems.add(new NewsItemBodyViewModel(wallItem));
                        baseItems.add(new NewsItemFooterViewModel(wallItem));
                        return Observable.fromIterable(baseItems);
                    }
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<BaseViewModel>>() {
                    @Override
                    public void accept(List<BaseViewModel> objects) throws Exception {
                        mAdapter.addItems(objects);
                    }
                });
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }
}
