package de.android.ayrathairullin.vkclient.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import javax.inject.Inject;

import de.android.ayrathairullin.vkclient.CurrentUser;
import de.android.ayrathairullin.vkclient.MyApplication;
import de.android.ayrathairullin.vkclient.R;
import de.android.ayrathairullin.vkclient.rest.api.WallApi;
import de.android.ayrathairullin.vkclient.rest.model.response.BaseItemResponse;
import de.android.ayrathairullin.vkclient.rest.model.response.Full;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFeedFragment extends BaseFragment {
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
        mWallApi.get("17864859", CurrentUser.getAccessTocken(), 1, "5.67").enqueue(new Callback<Full<BaseItemResponse>>() {
            @Override
            public void onResponse(Call<Full<BaseItemResponse>> call, Response<Full<BaseItemResponse>> response) {
                Toast.makeText(getActivity(), "Count " + response.body().response.getCount(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Full<BaseItemResponse>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

}
