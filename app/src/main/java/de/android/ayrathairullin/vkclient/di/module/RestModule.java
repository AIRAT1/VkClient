package de.android.ayrathairullin.vkclient.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.android.ayrathairullin.vkclient.rest.RestClient;
import de.android.ayrathairullin.vkclient.rest.api.GroupsApi;
import de.android.ayrathairullin.vkclient.rest.api.UsersApi;
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

    @Provides
    @Singleton
    public UsersApi provideUsersApi() {
        return mRestClient.createService(UsersApi.class);
    }

    @Provides
    @Singleton
    public GroupsApi provideGroupsApi() {
        return mRestClient.createService(GroupsApi.class);
    }
}
