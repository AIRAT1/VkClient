package de.android.ayrathairullin.vkclient.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.android.ayrathairullin.vkclient.R;
import de.android.ayrathairullin.vkclient.common.BaseAdapter;
import de.android.ayrathairullin.vkclient.common.manager.MyLinearLayoutManager;
import de.android.ayrathairullin.vkclient.model.view.BaseViewModel;
import de.android.ayrathairullin.vkclient.mvp.presenter.BaseFeedPresenter;
import de.android.ayrathairullin.vkclient.mvp.view.BaseFeedView;

public abstract class BaseFeedFragment extends BaseFragment implements BaseFeedView{
    @BindView(R.id.rv_list)
    RecyclerView mRecyclerView;
    BaseAdapter mAdapter;
    @BindView(R.id.swipe_refresh)
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected ProgressBar mProgressBar;
    protected BaseFeedPresenter mBaseFeedPresenter;
    private boolean isWithEndlessList;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
        setUpSwipeToRefreshLayout(view);
        mBaseFeedPresenter = onCreateFeedPresenter();
        mBaseFeedPresenter.loadStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isWithEndlessList = true;
    }

    private void setUpRecyclerView(View rootView) {
        MyLinearLayoutManager mLinearLayoutManager = new MyLinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        if (isWithEndlessList) {
            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    if (mLinearLayoutManager.isOnNextPagePosition()) {
                        mBaseFeedPresenter.loadNext(mAdapter.getRealItemCount());
                    }
                }
            });
        }
        ((SimpleItemAnimator)mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
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

    private void setUpSwipeToRefreshLayout(View rootView) {
        mSwipeRefreshLayout.setOnRefreshListener(() -> onCreateFeedPresenter().loadRefresh());
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mProgressBar = getBaseActivity().getProgressBar();
    }

    @Override
    public void showRefreshing() {

    }

    @Override
    public void hideRefreshing() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showListProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideListProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getBaseActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setItems(List<BaseViewModel> items) {
        mAdapter.setItems(items);
    }

    @Override
    public void addItems(List<BaseViewModel> items) {
        mAdapter.addItems(items);
    }

    protected abstract BaseFeedPresenter onCreateFeedPresenter();

    public void setWithEndlessList(boolean withEndlessList) {
        isWithEndlessList = withEndlessList;
    }
}
