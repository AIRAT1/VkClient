package de.android.ayrathairullin.vkclient.rest.api;


import java.util.List;
import java.util.Map;

import de.android.ayrathairullin.vkclient.model.Profile;
import de.android.ayrathairullin.vkclient.rest.model.response.Full;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface UsersApi {
    @GET(ApiMethods.USERS_GET)
    Observable<Full<List<Profile>>> get(@QueryMap Map<String, String> map);
}
