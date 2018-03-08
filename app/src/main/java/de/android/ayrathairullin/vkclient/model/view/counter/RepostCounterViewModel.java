package de.android.ayrathairullin.vkclient.model.view.counter;


import de.android.ayrathairullin.vkclient.model.Reposts;

public class RepostCounterViewModel extends CounterViewModel {
    private Reposts mReposts;

    public RepostCounterViewModel(Reposts reposts) {
        super(reposts.getCount());
        this.mReposts = reposts;
        if (mReposts.getUserReposted() == 1) {
            setAccentColor();
        }
    }

    public Reposts getReposts() {
        return mReposts;
    }
}
