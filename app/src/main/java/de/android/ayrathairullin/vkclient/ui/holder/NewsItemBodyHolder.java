package de.android.ayrathairullin.vkclient.ui.holder;


import android.view.View;
import android.widget.TextView;

import de.android.ayrathairullin.vkclient.R;
import de.android.ayrathairullin.vkclient.model.view.NewsFeedItemBodyViewModel;

public class NewsItemBodyHolder extends BaseViewHolder<NewsFeedItemBodyViewModel>{
    public TextView mText;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        this.mText = itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsFeedItemBodyViewModel newsFeedItemBodyViewModel) {
        mText.setText(newsFeedItemBodyViewModel.getText());
    }

    @Override
    public void unbindViewHolder() {
        mText.setText(null);
    }
}
