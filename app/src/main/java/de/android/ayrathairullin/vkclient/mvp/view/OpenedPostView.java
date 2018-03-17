package de.android.ayrathairullin.vkclient.mvp.view;


import de.android.ayrathairullin.vkclient.model.view.NewsItemFooterViewModel;

public interface OpenedPostView extends BaseFeedView{
    void setFooter(NewsItemFooterViewModel viewModel);
}
