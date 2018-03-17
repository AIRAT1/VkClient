package de.android.ayrathairullin.vkclient.di.component;


import javax.inject.Singleton;

import dagger.Component;
import de.android.ayrathairullin.vkclient.common.manager.NetworkManager;
import de.android.ayrathairullin.vkclient.di.module.ApplicationModule;
import de.android.ayrathairullin.vkclient.di.module.ManagerModule;
import de.android.ayrathairullin.vkclient.di.module.RestModule;
import de.android.ayrathairullin.vkclient.mvp.presenter.BoardPresenter;
import de.android.ayrathairullin.vkclient.mvp.presenter.InfoPresenter;
import de.android.ayrathairullin.vkclient.mvp.presenter.MainPresenter;
import de.android.ayrathairullin.vkclient.mvp.presenter.MembersPresenter;
import de.android.ayrathairullin.vkclient.mvp.presenter.NewsFeedPresenter;
import de.android.ayrathairullin.vkclient.ui.activity.BaseActivity;
import de.android.ayrathairullin.vkclient.ui.activity.MainActivity;
import de.android.ayrathairullin.vkclient.ui.fragment.NewsFeedFragment;
import de.android.ayrathairullin.vkclient.ui.view.holder.NewsItemBodyHolder;
import de.android.ayrathairullin.vkclient.ui.view.holder.NewsItemFooterHolder;
import de.android.ayrathairullin.vkclient.ui.view.holder.attachment.ImageAttachmentHolder;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {
    // activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);
    // fragments
    void inject(NewsFeedFragment fragment);
    // holders
    void inject(NewsItemBodyHolder holder);
    void inject(NewsItemFooterHolder holder);
    void inject(ImageAttachmentHolder holder);
    // presenters
    void inject(NewsFeedPresenter presenter);
    void inject(MainPresenter presenter);
    void inject(MembersPresenter presenter);
    void inject(BoardPresenter presenter);
    void inject(InfoPresenter presenter);
    // managers
    void inject(NetworkManager manager);
}
