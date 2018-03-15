package de.android.ayrathairullin.vkclient.rest.api;


import java.util.Map;

import de.android.ayrathairullin.vkclient.model.Topic;
import de.android.ayrathairullin.vkclient.rest.model.response.BaseItemResponse;
import de.android.ayrathairullin.vkclient.rest.model.response.Full;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface BoardApi {
    @GET(ApiMethods.BOARD_GET_TOPICS)
    Observable<Full<BaseItemResponse<Topic>>> getTopios(@QueryMap Map<String, String> map);
}
