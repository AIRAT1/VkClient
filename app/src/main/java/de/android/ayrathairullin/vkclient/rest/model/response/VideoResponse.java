package de.android.ayrathairullin.vkclient.rest.model.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import de.android.ayrathairullin.vkclient.model.attachment.Video;

public class VideoResponse {
    public int count;

    @SerializedName("items")
    @Expose
    public List<Video> items;
}
