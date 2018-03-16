package de.android.ayrathairullin.vkclient.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.android.ayrathairullin.vkclient.rest.RestClient;
import de.android.ayrathairullin.vkclient.rest.api.BoardApi;
import de.android.ayrathairullin.vkclient.rest.api.GroupsApi;
import de.android.ayrathairullin.vkclient.rest.api.UsersApi;
import de.android.ayrathairullin.vkclient.rest.api.VideoApi;
import de.android.ayrathairullin.vkclient.rest.api.WallApi;

@Module
public class RestModule {
    private RestClient mRestClient;

    public RestModule() {
        mRestClient = new RestClient();
    }

    @Provides
    @Singleton
    public VideoApi provideVideoApi() {
        return mRestClient.createService(VideoApi.class);
    }

    @Provides
    @Singleton
    public RestClient provideRestClient() {
        return mRestClient;
    }

    @Provides
    @Singleton
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

    @Provides
    @Singleton
    public BoardApi provideBoardApi() {
        return mRestClient.createService(BoardApi.class);
    }
}
