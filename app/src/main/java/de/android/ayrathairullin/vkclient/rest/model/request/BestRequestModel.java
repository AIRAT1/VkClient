package de.android.ayrathairullin.vkclient.rest.model.request;


import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;

import de.android.ayrathairullin.vkclient.consts.ApiConstants;

public class BestRequestModel {
    @SerializedName(VKApiConst.VERSION)
    Double version = ApiConstants.DEFAULT_VERSION;
}
