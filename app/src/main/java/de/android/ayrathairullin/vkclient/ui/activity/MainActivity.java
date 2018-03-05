package de.android.ayrathairullin.vkclient.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import de.android.ayrathairullin.vkclient.CurrentUser;
import de.android.ayrathairullin.vkclient.R;
import de.android.ayrathairullin.vkclient.consts.ApiConstants;
import de.android.ayrathairullin.vkclient.mvp.presenter.MainPresenter;
import de.android.ayrathairullin.vkclient.mvp.view.MainView;

public class MainActivity extends BaseActivity implements MainView {

    @InjectPresenter
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.checkAuth();
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                // Пользователь успешно авторизовался
                mPresenter.checkAuth();
            }

            @Override
            public void onError(VKError error) {
                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void startSignIn() {
        VKSdk.login(this, ApiConstants.DEFAULT_LOGINSCOPE);
    }

    @Override
    public void signedIn() {
        Toast.makeText(this, "Current user id: " + CurrentUser.getId(), Toast.LENGTH_LONG).show();
    }
}
