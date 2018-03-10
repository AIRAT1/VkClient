package de.android.ayrathairullin.vkclient;


import android.app.Application;

import com.vk.sdk.VKSdk;

import de.android.ayrathairullin.vkclient.di.component.ApplicationComponent;
import de.android.ayrathairullin.vkclient.di.component.DaggerApplicationComponent;
import de.android.ayrathairullin.vkclient.di.module.ApplicationModule;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application{
    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        VKSdk.initialize(this);
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private void initComponent() {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
