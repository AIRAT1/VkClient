package de.android.ayrathairullin.vkclient.mvp.presenter;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import de.android.ayrathairullin.vkclient.CurrentUser;
import de.android.ayrathairullin.vkclient.MyApplication;
import de.android.ayrathairullin.vkclient.common.manager.MyFragmentManager;
import de.android.ayrathairullin.vkclient.common.manager.NetworkManager;
import de.android.ayrathairullin.vkclient.model.Profile;
import de.android.ayrathairullin.vkclient.mvp.view.MainView;
import de.android.ayrathairullin.vkclient.rest.api.UsersApi;
import de.android.ayrathairullin.vkclient.rest.model.request.UsersGetRequestModel;
import de.android.ayrathairullin.vkclient.ui.fragment.BaseFragment;
import de.android.ayrathairullin.vkclient.ui.fragment.MembersFragment;
import de.android.ayrathairullin.vkclient.ui.fragment.MyPostsFragment;
import de.android.ayrathairullin.vkclient.ui.fragment.NewsFeedFragment;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmObject;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    @Inject
    MyFragmentManager myFragmentManager;
    @Inject
    UsersApi mUserApi;
    @Inject
    NetworkManager mNetworkManager;

    public void checkAuth() {
        if (!CurrentUser.isAuthorized()) {
            getViewState().startSignIn();
        } else {
            getCurrentUser();
            getViewState().signedIn();
        }
    }

    public MainPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }

    public Observable<Profile> getProfileFromNetwork() {
        return mUserApi.get(new UsersGetRequestModel(CurrentUser.getId()).toMap())
                .flatMap(listFull -> Observable.fromIterable(listFull.response))
                .doOnNext(this::saveToDb);
    }

    private Observable<Profile> getProfileFromDb() {
        return Observable.fromCallable(getListFromRealmCallable());
    }

    public void saveToDb(RealmObject item) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(item));
    }

    public Callable<Profile> getListFromRealmCallable() {
        return () -> {
            Realm realm = Realm.getDefaultInstance();
            Profile realmResults = realm.where(Profile.class)
                    .equalTo("id", Integer.parseInt(CurrentUser.getId()))
                    .findFirst();
            return realm.copyFromRealm(realmResults);
        };
    }

    private void getCurrentUser() {
        mNetworkManager.getNetworkObservable()
                .flatMap(aBoolean -> {
                    if (!CurrentUser.isAuthorized()) {
                        getViewState().startSignIn();
                    }
                    return aBoolean
                            ? getProfileFromNetwork()
                            : getProfileFromDb();
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(profile -> {
                    getViewState().showCurrentUser(profile);
                }, error -> {
                    error.printStackTrace();
                });
    }

    public void drawerItemClick(int id) {
        BaseFragment fragment = null;
        switch (id) {
            case 1:
                fragment = new NewsFeedFragment();
                break;
            case 2:
                fragment = new MyPostsFragment();
                break;
            case 4:
                fragment = new MembersFragment();
                break;
        }
        if (fragment != null && !myFragmentManager.isAlreadyContains(fragment)) {
            getViewState().showFragmentFromDrawer(fragment);
        }
    }
}
