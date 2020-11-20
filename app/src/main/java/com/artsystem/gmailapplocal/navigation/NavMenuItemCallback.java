package com.artsystem.gmailapplocal.navigation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class NavMenuItemCallback extends DiffUtil.ItemCallback<NavItem> {
    @Override
    public boolean areItemsTheSame(@NonNull NavItem oldItem, @NonNull NavItem newItem) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull NavItem oldItem, @NonNull NavItem newItem) {
        return false;
    }
}
