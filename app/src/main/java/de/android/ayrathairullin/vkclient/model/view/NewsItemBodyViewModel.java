package de.android.ayrathairullin.vkclient.model.view;


import android.view.View;

import de.android.ayrathairullin.vkclient.model.WallItem;
import de.android.ayrathairullin.vkclient.ui.holder.BaseViewHolder;
import de.android.ayrathairullin.vkclient.ui.holder.NewsItemBodyHolder;

public class NewsItemBodyViewModel extends BaseViewModel {
    private int mId;
    private String mText;
    private String mAttachmentString;
    private boolean mIsRepost;

    public NewsItemBodyViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mIsRepost = wallItem.haveSharedRepost();
        if (mIsRepost) {
            this.mText = wallItem.getSharedRepost().getText();
            this.mAttachmentString = wallItem.getSharedRepost().getAttachmentsString();
        }else {
            this.mText = wallItem.getText();
            this.mAttachmentString = wallItem.getAttachmentsString();
        }
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }

    public int getId() {
        return mId;
    }

    public String getText() {
        return mText;
    }

    public String getmAttachmentString() {
        return mAttachmentString;
    }
}
