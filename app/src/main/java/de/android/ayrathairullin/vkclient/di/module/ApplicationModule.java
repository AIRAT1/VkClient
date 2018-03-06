package de.android.ayrathairullin.vkclient.di.module;


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private Application mApplication;

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return mApplication;
    }
}
