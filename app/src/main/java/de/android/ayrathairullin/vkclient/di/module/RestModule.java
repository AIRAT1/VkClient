package de.android.ayrathairullin.vkclient.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.android.ayrathairullin.vkclient.rest.RestClient;
import de.android.ayrathairullin.vkclient.rest.api.WallApi;

@Module
public class RestModule {
    private RestClient mRestClient;

    public RestModule() {
        mRestClient = new RestClient();
    }

    @Singleton
    @Provides
    public RestClient provideRestClient() {
        return mRestClient;
    }

    @Singleton
    @Provides
    public WallApi provideWallApi() {
        return mRestClient.createService(WallApi.class);
    }
}
