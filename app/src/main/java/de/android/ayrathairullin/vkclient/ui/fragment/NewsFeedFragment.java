package de.android.ayrathairullin.vkclient.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        mWallApi.get(new WallGetRequestModel(-1090630).toMap()).enqueue(new Callback<GetWallResponse>() {
            @Override
            public void onResponse(Call<GetWallResponse> call, Response<GetWallResponse> response) {
                List<WallItem> wallItems = VkListHelper.getWallList(response.body().response);
                List<BaseViewModel> list = new ArrayList<>();

                for (WallItem item : wallItems) {
                    list.add(new NewsItemHeaderViewModel(item));
                    list.add(new NewsItemBodyViewModel(item));
                    list.add(new NewsItemFooterViewModel(item));
                }
                mAdapter.addItems(list);
                Toast.makeText(getActivity(), "Likes: " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<GetWallResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }
}
