package de.android.ayrathairullin.vkclient.model.view;


import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.android.ayrathairullin.vkclient.R;
import de.android.ayrathairullin.vkclient.ui.holder.BaseViewHolder;

public class InfoContactsViewModel extends BaseViewModel {
    @Override
    public LayoutTypes getType() {
        return LayoutTypes.InfoContacts;
    }

    @Override
    public InfoContactsViewHolder onCreateViewHolder(View view) {
        return new InfoContactsViewHolder(view);
    }

    static class InfoContactsViewHolder extends BaseViewHolder<InfoContactsViewModel> {
        @BindView(R.id.rv_contacts)
        RelativeLayout rvContacts;


        public InfoContactsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindViewHolder(InfoContactsViewModel infoContactsViewModel) {

        }

        @Override
        public void unbindViewHolder() {

        }
    }
}
