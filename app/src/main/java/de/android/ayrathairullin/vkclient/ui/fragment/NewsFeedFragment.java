package de.android.ayrathairullin.vkclient.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.android.ayrathairullin.vkclient.MyApplication;
import de.android.ayrathairullin.vkclient.R;
import de.android.ayrathairullin.vkclient.common.BaseAdapter;
import de.android.ayrathairullin.vkclient.common.utils.VkListHelper;
import de.android.ayrathairullin.vkclient.model.WallItem;
import de.android.ayrathairullin.vkclient.model.view.BaseViewModel;
import de.android.ayrathairullin.vkclient.model.view.NewsFeedItemBodyViewModel;
import de.android.ayrathairullin.vkclient.model.view.NewsItemHeaderViewModel;
import de.android.ayrathairullin.vkclient.rest.api.WallApi;
import de.android.ayrathairullin.vkclient.rest.model.request.WallGetRequestModel;
import de.android.ayrathairullin.vkclient.rest.model.response.GetWallResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFeedFragment extends BaseFragment {
    @Inject
    WallApi mWallApi;

    RecyclerView mRecyclerView;

    BaseAdapter mAdapter;

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
        mWallApi.get(new WallGetRequestModel(-1090630).toMap()).enqueue(new Callback<GetWallResponse>() { // 17864859
            @Override
            public void onResponse(Call<GetWallResponse> call, Response<GetWallResponse> response) {
                List<WallItem> wallItems = VkListHelper.getWallList(response.body().response);
                List<BaseViewModel> list = new ArrayList<>();
                for (WallItem item : wallItems) {
                    list.add(new NewsItemHeaderViewModel(item));
                    list.add(new NewsFeedItemBodyViewModel(item));
                }
                mAdapter.addItems(list);
                Toast.makeText(getActivity(), "Likes " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<GetWallResponse> call, Throwable t) {
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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
    }

    private void setUpRecyclerView(View rootView){
        mRecyclerView = rootView.findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setUpAdapter(RecyclerView recyclerView) {
        mAdapter = new BaseAdapter();
        recyclerView.setAdapter(mAdapter);
    }
}
