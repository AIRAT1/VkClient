package de.android.ayrathairullin.vkclient.rest.model.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Full<T> {
    @SerializedName("response")
    @Expose
    public T response;
}
