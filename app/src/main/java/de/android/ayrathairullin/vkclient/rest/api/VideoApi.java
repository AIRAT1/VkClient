package de.android.ayrathairullin.vkclient.rest.api;


import java.util.Map;

import de.android.ayrathairullin.vkclient.rest.model.response.Full;
import de.android.ayrathairullin.vkclient.rest.model.response.VideoResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface VideoApi {
    @GET(ApiMethods.VIDEO_GET)
    Observable<Full<VideoResponse>> get(@QueryMap Map<String, String> map);
}
