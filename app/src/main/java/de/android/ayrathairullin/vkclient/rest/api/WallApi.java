package de.android.ayrathairullin.vkclient.rest.api;


import java.util.Map;

import de.android.ayrathairullin.vkclient.rest.model.response.WallGetResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WallApi {
    @GET(ApiMethods.WALL_GET)
    Call<WallGetResponse> get(@QueryMap Map<String, String> map);
}
