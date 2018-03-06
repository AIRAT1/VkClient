package de.android.ayrathairullin.vkclient.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.android.ayrathairullin.vkclient.common.manager.MyFragmentManager;

@Module
public class ManagerModule {
    @Singleton
    @Provides
    MyFragmentManager provideMyFragmentManager() {
        return new MyFragmentManager();
    }
}
