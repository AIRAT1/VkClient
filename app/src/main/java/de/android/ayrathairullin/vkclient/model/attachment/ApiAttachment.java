
package de.android.ayrathairullin.vkclient.model.attachment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.model.VKAttachments;

import java.util.NoSuchElementException;

public class ApiAttachment {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("photo")
    @Expose
    private Photo photo;
    @SerializedName("audio")
    @Expose
    private Audio audio;
    @SerializedName("video")
    @Expose
    private Video video;
    @SerializedName("doc")
    @Expose
    private Doc doc;
    @SerializedName("link")
    @Expose
    private Link link;
    @SerializedName("page")
    @Expose
    private Page page;

    public Attachment getAttachment() {
        switch (type) {
            case VKAttachments.TYPE_PHOTO:
                return photo;
            case VKAttachments.TYPE_AUDIO:
                return audio;
            case VKAttachments.TYPE_VIDEO:
                return video;
            case VKAttachments.TYPE_DOC:
                return doc;
            case VKAttachments.TYPE_LINK:
                return link;
            case VKAttachments.TYPE_WIKI_PAGE:
                return page;
                default:
                    throw new NoSuchElementException("Attachment type " + type + " is not supported");
        }
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

}
