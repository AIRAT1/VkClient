package de.android.ayrathairullin.vkclient.ui.holder;


import android.content.Context;
import android.support.v7.widget.RecyclerView;

import de.android.ayrathairullin.vkclient.model.view.BaseViewModel;

public abstract class BaseViewHolder<Item extends BaseViewModel> extends RecyclerView{
    public BaseViewHolder(Context context) {
        super(context);
    }

    public abstract void bindViewHolder(Item item);
    public abstract void unbindViewHolder();
}
