package de.android.ayrathairullin.vkclient.common.utils;


import java.util.List;

import de.android.ayrathairullin.vkclient.model.Owner;
import de.android.ayrathairullin.vkclient.model.WallItem;
import de.android.ayrathairullin.vkclient.rest.model.response.ItemWithSendersResponse;

public class VkListHelper {
    public static List<WallItem> getWallList(ItemWithSendersResponse<WallItem> response) {
        List<WallItem> wallItems = response.items;
        for (WallItem wallItem : wallItems) {
            Owner sender = response.getSender(wallItem.getFromId());
            wallItem.setSenderName(sender.getFullName());
            wallItem.setSenderPhoto(sender.getPhoto());
            wallItem.setAttachmentsString(Utils.convertAttachmentsToFontIcons(wallItem.getAttachments()));

            if (wallItem.haveSharedRepost()) {
                Owner repostSender = response.getSender(wallItem.getSharedRepost().getFromId());
                wallItem.getSharedRepost().setSenderName(repostSender.getFullName());
                wallItem.getSharedRepost().setSenderPhoto(repostSender.getPhoto());
                wallItem.getSharedRepost().setAttachmentsString(Utils.convertAttachmentsToFontIcons(
                        wallItem.getSharedRepost().getAttachments()
                ));
            }
        }
        return wallItems;
    }
}
