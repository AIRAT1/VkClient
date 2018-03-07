package de.android.ayrathairullin.vkclient.model.view;


import android.view.View;

import de.android.ayrathairullin.vkclient.model.WallItem;
import de.android.ayrathairullin.vkclient.ui.holder.BaseViewHolder;
import de.android.ayrathairullin.vkclient.ui.holder.NewsItemBodyHolder;

public class NewsFeedItemBodyViewModel extends BaseViewModel {
    private int mId;
    private String mText;

    public NewsFeedItemBodyViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mText = wallItem.getText();
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
}
