package de.android.ayrathairullin.vkclient.model;


import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Member extends RealmObject{
    public static final String ID = "id";
    public static final String GROUP_ID = "group_id";
    public static final String PHOTO = "photo_100";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";

    @PrimaryKey
    @SerializedName(ID)
    private int id;
    @SerializedName(GROUP_ID)
    private int group_id;
    @SerializedName(PHOTO)
    private String photo;
    @SerializedName(FIRST_NAME)
    private String first_name;
    @SerializedName(LAST_NAME)
    private String last_name;

    public Member() {
    }

    public Member(Profile profile) {
        this.id = profile.getId();
        this.photo = profile.getPhoto();
        this.first_name = profile.getFirstName();
        this.last_name = profile.getLastName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFullName() {
        return first_name + " " + last_name;
    }
}
