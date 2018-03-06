package de.android.ayrathairullin.vkclient;


import android.app.Application;

import com.vk.sdk.VKSdk;

import de.android.ayrathairullin.vkclient.di.component.ApplicationComponent;
import de.android.ayrathairullin.vkclient.di.component.DaggerApplicationComponent;
import de.android.ayrathairullin.vkclient.di.module.ApplicationModule;

public class MyApplication extends Application{
    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        VKSdk.initialize(this);
    }

    private void initComponent() {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
