package com.artsystem.gmailapplocal.maillist;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class MailDiffUtilCallback extends DiffUtil.ItemCallback<MailItem> {

    @Override
    public boolean areItemsTheSame(@NonNull MailItem oldItem, @NonNull MailItem newItem) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull MailItem oldItem, @NonNull MailItem newItem) {
        return false;
    }
}
