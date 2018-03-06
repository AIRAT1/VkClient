package de.android.ayrathairullin.vkclient.di.component;


import javax.inject.Singleton;

import dagger.Component;
import de.android.ayrathairullin.vkclient.di.module.ApplicationModule;
import de.android.ayrathairullin.vkclient.di.module.ManagerModule;
import de.android.ayrathairullin.vkclient.di.module.RestModule;
import de.android.ayrathairullin.vkclient.ui.activity.BaseActivity;
import de.android.ayrathairullin.vkclient.ui.activity.MainActivity;
import de.android.ayrathairullin.vkclient.ui.fragment.NewsFeedFragment;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity activity);
    void inject(MainActivity activity);
    void inject(NewsFeedFragment fragment);
}
