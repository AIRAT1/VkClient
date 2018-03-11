package de.android.ayrathairullin.vkclient.ui.fragment;


import android.os.Bundle;

import de.android.ayrathairullin.vkclient.R;

public class MyPostsFragment extends NewsFeedFragment{
    public MyPostsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.setEnableIdFiltering(true);
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_my_posts;
    }
}
