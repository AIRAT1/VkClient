package de.android.ayrathairullin.vkclient.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.android.ayrathairullin.vkclient.common.manager.MyFragmentManager;
import de.android.ayrathairullin.vkclient.common.manager.NetworkManager;

@Module
public class ManagerModule {
    @Singleton
    @Provides
    MyFragmentManager provideMyFragmentManager() {
        return new MyFragmentManager();
    }

    @Provides
    @Singleton
    NetworkManager providerNetworkManager() {
        return new NetworkManager();
    }
}
