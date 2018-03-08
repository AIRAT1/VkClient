package de.android.ayrathairullin.vkclient.model.view.counter;


import de.android.ayrathairullin.vkclient.model.Likes;

public class LikeCounterViewModel extends CounterViewModel{
    private Likes mLikes;

    public LikeCounterViewModel(Likes likes) {
        super(likes.getCount());
        this.mLikes = likes;
        if (mLikes.getUserLikes() == 1) {
            setAccentColor();
        }
    }

    public Likes getLikes() {
        return mLikes;
    }
}
