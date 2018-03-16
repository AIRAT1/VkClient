package de.android.ayrathairullin.vkclient.rest.model.request;


import com.google.gson.annotations.SerializedName;

import java.util.Map;

import de.android.ayrathairullin.vkclient.consts.ApiConstants;

public class VideoGetRequestModel extends BaseRequestModel{
    @SerializedName(ApiConstants.VIDEOS)
    String videos;

    public VideoGetRequestModel() {
    }

    public VideoGetRequestModel(String ownerId, String videoId) {
        this.videos = ownerId + "_" + videoId;
    }

    @Override
    public void onMapCreate(Map<String, String> map) {

    }
}
