package de.android.ayrathairullin.vkclient.model.view.counter;


import de.android.ayrathairullin.vkclient.model.Comments;

public class CommentCounterViewModel extends CounterViewModel {
    private Comments mComments;

    public CommentCounterViewModel(Comments comments) {
        super(comments.getCount());
        this.mComments = comments;
    }

    public Comments getComments() {
        return mComments;
    }
}
