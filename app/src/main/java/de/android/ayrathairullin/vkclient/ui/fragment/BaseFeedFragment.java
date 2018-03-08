package de.android.ayrathairullin.vkclient.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import de.android.ayrathairullin.vkclient.R;
import de.android.ayrathairullin.vkclient.common.BaseAdapter;

public class BaseFeedFragment extends BaseFragment{
    RecyclerView mRecyclerView;

    BaseAdapter mAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
    }

    private void setUpRecyclerView(View rootView) {
        mRecyclerView = rootView.findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    protected void setUpAdapter(RecyclerView rv) {
        mAdapter = new BaseAdapter();
        rv.setAdapter(mAdapter);
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public int onCreateToolbarTitle() {
        return 0;
    }
}
