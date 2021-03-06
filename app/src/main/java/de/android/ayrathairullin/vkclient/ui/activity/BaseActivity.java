package de.android.ayrathairullin.vkclient.ui.activity;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.android.ayrathairullin.vkclient.MyApplication;
import de.android.ayrathairullin.vkclient.R;
import de.android.ayrathairullin.vkclient.common.manager.MyFragmentManager;
import de.android.ayrathairullin.vkclient.ui.fragment.BaseFragment;

public abstract class BaseActivity extends MvpAppCompatActivity {
    @BindView(R.id.progress)
    protected ProgressBar mProgressBar;
    @Inject
    MyFragmentManager myFragmentManager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    public FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
        MyApplication.getApplicationComponent().inject(this);
        setSupportActionBar(toolbar);
        FrameLayout parent = findViewById(R.id.main_wrapper);
        getLayoutInflater().inflate(getMainContentLayout(), parent, false);
    }

    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    @LayoutRes
    protected abstract int getMainContentLayout();

    public void fragmentOnScreen(BaseFragment fragment) {
        setToolbarTitle(fragment.createToolbarTitle(this));
        setupFabVisibility(fragment.needFab());
    }

    public void setToolbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void setupFabVisibility(boolean needFab) {
        if (mFab == null) return;

        if (needFab) {
            mFab.show();
        } else {
            mFab.hide();
        }
    }

    public void setContent(BaseFragment fragment) {
        myFragmentManager.setFragment(this, fragment, R.id.main_wrapper);
    }

    public void addContent(BaseFragment fragment) {
        myFragmentManager.addFragment(this, fragment, R.id.main_wrapper);
    }

    public boolean removeCurrentFragment() {
        return myFragmentManager.removeCurrentFragment(this);
    }

    public boolean removeFragment(BaseFragment fragment) {
        return myFragmentManager.removeFragment(this, fragment);
    }

    @Override
    public void onBackPressed() {
        removeCurrentFragment();
    }
}
