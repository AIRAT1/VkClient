package de.android.ayrathairullin.vkclient.mvp.presenter;


import com.arellomobile.mvp.InjectViewState;

import de.android.ayrathairullin.vkclient.model.view.BaseViewModel;
import de.android.ayrathairullin.vkclient.mvp.view.BaseFeedView;
import io.reactivex.Observable;

@InjectViewState
public class BoardPresenter extends BaseFeedPresenter<BaseFeedView>{
    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return null;
    }

    @Override
    public Observable<BaseViewModel> onCreateRestoreDataObservable() {
        return null;
    }
}
