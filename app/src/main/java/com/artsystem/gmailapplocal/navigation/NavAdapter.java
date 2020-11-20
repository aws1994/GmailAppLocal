package com.artsystem.gmailapplocal.navigation;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.artsystem.gmailapplocal.R;
import com.artsystem.gmailapplocal.data.Constant;

public class NavAdapter extends ListAdapter<NavItem,NavAdapter.NavBaseViewHolder> {


    public NavAdapter(@NonNull DiffUtil.ItemCallback<NavItem> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public NavBaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


       switch (viewType) {
           case Constant.NAV_MENU_TYPE:
           View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nav_menu,parent,false);
           return new MenuViewHolder(v);

           case Constant.NAV_TEXT_TYPE:
                View v2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nav_label,parent,false);
                return new LabelViewHolder(v2);


                default:
               View def = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nav_label,parent,false);
               return new LabelViewHolder(def);

       }
    }

    @Override
    public void onBindViewHolder(@NonNull NavBaseViewHolder holder, int position) {

        holder.bindData(getItem(position));

    }

    @Override
    public int getItemViewType(int position) {

        return getItem(position).getType();

    }

    public abstract class NavBaseViewHolder extends RecyclerView.ViewHolder {

        public NavBaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        abstract void bindData(NavItem item);


    }

    // Simple Label ViewHolder type class: extends BASEViewholder
    public class LabelViewHolder extends NavBaseViewHolder {

        TextView labelTv;

        public LabelViewHolder(@NonNull View itemView) {
            super(itemView);
            labelTv = itemView.findViewById(R.id.nav_label);
        }

        @Override
        void bindData(NavItem item) {
            labelTv.setText(item.getLabelItem().getLabel());
        }
    }

    // Menu Item ViewHolder type class: extends BASEViewHolder
    public class MenuViewHolder extends  NavBaseViewHolder {

        TextView menuTitle,num;
        ImageView icon;
        ConstraintLayout container;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            menuTitle = itemView.findViewById(R.id.nav_title);
            num = itemView.findViewById(R.id.nav_num);
            icon = itemView.findViewById(R.id.icon);
            container = itemView.findViewById(R.id.nav_item_container);
        }

        @Override
        void bindData(NavItem item) {
            menuTitle.setText(item.getMenuItem().getTitle());
            icon.setImageResource(item.getMenuItem().getIcon());
            if (item.getMenuItem().getNumNotification() != 0) {
                num.setVisibility(View.VISIBLE);
                num.setText(""+item.getMenuItem().getNumNotification());
            }
            if (item.getMenuItem().getNumNotification()>99) {
                num.setVisibility(View.VISIBLE);
                num.setText("+99");
            }
            else
                num.setVisibility(View.GONE);

            setSelected(item.getMenuItem().isSelected());
        }

        void setSelected(boolean isSelected) {

            if (isSelected) {
                container.setBackground(container.getContext().getResources().getDrawable(R.drawable.nav_select_bg));
            }
            else {
                container.setBackground(new ColorDrawable(Color.TRANSPARENT));
            }
        }


    }

}
