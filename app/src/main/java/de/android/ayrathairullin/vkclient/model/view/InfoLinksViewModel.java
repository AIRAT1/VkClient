package de.android.ayrathairullin.vkclient.model.view;


import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.android.ayrathairullin.vkclient.R;
import de.android.ayrathairullin.vkclient.ui.holder.BaseViewHolder;

public class InfoLinksViewModel extends BaseViewModel{
    @Override
    public LayoutTypes getType() {
        return LayoutTypes.InfoLinks;
    }

    @Override
    public InfoLinkViewHolder onCreateViewHolder(View view) {
        return new InfoLinkViewHolder(view);
    }

    static class InfoLinkViewHolder extends BaseViewHolder<InfoLinksViewModel> {
        @BindView(R.id.rv_links)
        RelativeLayout rvLinks;

        public InfoLinkViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindViewHolder(InfoLinksViewModel infoLinksViewModel) {

        }

        @Override
        public void unbindViewHolder() {

        }
    }
}
