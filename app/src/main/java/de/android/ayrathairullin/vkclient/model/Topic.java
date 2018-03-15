package de.android.ayrathairullin.vkclient.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.model.Identifiable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Topic extends RealmObject implements Identifiable{
    @PrimaryKey
    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("comments")
    @Expose
    public String comments;

    public int groupId;

    @Override
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getComments() {
        return comments;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
