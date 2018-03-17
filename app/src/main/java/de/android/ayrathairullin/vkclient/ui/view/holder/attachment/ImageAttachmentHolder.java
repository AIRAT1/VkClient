package de.android.ayrathairullin.vkclient.ui.view.holder.attachment;


import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.android.ayrathairullin.vkclient.MyApplication;
import de.android.ayrathairullin.vkclient.R;
import de.android.ayrathairullin.vkclient.common.manager.MyFragmentManager;
import de.android.ayrathairullin.vkclient.model.view.attachment.ImageAttachmentViewModel;
import de.android.ayrathairullin.vkclient.ui.activity.BaseActivity;
import de.android.ayrathairullin.vkclient.ui.fragment.ImageFragment;
import de.android.ayrathairullin.vkclient.ui.view.holder.BaseViewHolder;

public class ImageAttachmentHolder extends BaseViewHolder<ImageAttachmentViewModel>{
    @BindView(R.id.iv_attachment_image)
    public ImageView image;

    @Inject
    MyFragmentManager mFragmentManager;

    public ImageAttachmentHolder(View itemView) {
        super(itemView);
        MyApplication.getApplicationComponent().inject(this);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(ImageAttachmentViewModel imageAttachmentViewModel) {
        if (imageAttachmentViewModel.needClick) {
            itemView.setOnClickListener(view -> mFragmentManager.addFragment((BaseActivity) itemView.getContext(),
                    ImageFragment.newInstance(imageAttachmentViewModel.getPhotoUrl()), R.id.main_wrapper));
        }
        Glide.with(itemView.getContext()).load(imageAttachmentViewModel.getPhotoUrl()).into(image);
    }

    @Override
    public void unbindViewHolder() {
        itemView.setOnClickListener(null);
        image.setImageBitmap(null);
    }
}
