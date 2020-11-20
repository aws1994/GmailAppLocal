package com.artsystem.gmailapplocal.maillist;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.artsystem.gmailapplocal.R;
import com.artsystem.gmailapplocal.data.Constant;
import com.bumptech.glide.Glide;

public class MailAdapter extends ListAdapter<MailItem, MailAdapter.MailBaseViewHolder> {


    public MailAdapter(@NonNull DiffUtil.ItemCallback<MailItem> diffCallback) {
            super(diffCallback);
        }


    @NonNull
    @Override
    public MailBaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case Constant.MAIL_CATEGORY_TYPE :
                return new CatViewHolder (LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_category,parent,false));
            case Constant.MAIL_ITEM_TYPE:
                return new MailViewHolder (LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_mail,parent,false));
            default:  return new MailViewHolder (LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_mail,parent,false));
        }


    }

    @Override
    public void onBindViewHolder(@NonNull MailBaseViewHolder holder, int position) {

        holder.bindData(getItem(position));

    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }


    // Base View Holder:
    public  abstract class MailBaseViewHolder extends RecyclerView.ViewHolder{

        abstract void bindData(MailItem item);

        public MailBaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }



    // categorie item ViewHolder
    public class CatViewHolder extends MailBaseViewHolder{

        TextView tvTitle,tvDesc,tvContent,tvNum;
        ImageView imgCat;


        public CatViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.item_cat_title);
            //tvContent = itemView.findViewById(R.id.item_mail_content);
            tvDesc = itemView.findViewById(R.id.item_cat_description);
            tvNum = itemView.findViewById(R.id.item_cat_counter);

            imgCat = itemView.findViewById(R.id.item_cat_img);
        }

        @Override
        void bindData(MailItem item) {

            tvTitle.setText(item.getCategoryItem().getTitle());
            tvDesc.setText(item.getCategoryItem().getDesc());
            tvNum.setText(item.getCategoryItem().getNumNotif()+" new");
            Glide.with(imgCat.getContext()).load(item.getCategoryItem().getIcon()).into(imgCat);
            switch (item.getCategoryItem().getColor()) {

                case "GREEN" :
                    imgCat.setColorFilter(imgCat.getContext().getResources().getColor(R.color.green));
                    DrawableCompat.setTint(tvNum.getBackground(),imgCat.getContext().getResources().getColor(R.color.green));
                    break;
                case "BLACK" :
                    imgCat.setColorFilter(imgCat.getContext().getResources().getColor(R.color.black));
                    DrawableCompat.setTint(tvNum.getBackground(),imgCat.getContext().getResources().getColor(R.color.black));
                    break;
                case "YELLOW" :
                    imgCat.setColorFilter(imgCat.getContext().getResources().getColor(R.color.yellow));
                    DrawableCompat.setTint(tvNum.getBackground(),imgCat.getContext().getResources().getColor(R.color.yellow));
                    break;
                case "BLUE" :
                    imgCat.setColorFilter(imgCat.getContext().getResources().getColor(R.color.blue));
                    DrawableCompat.setTint(tvNum.getBackground(),imgCat.getContext().getResources().getColor(R.color.blue));
                    break;
                case "PURPLE" :
                    imgCat.setColorFilter(imgCat.getContext().getResources().getColor(R.color.purple));
                    DrawableCompat.setTint(tvNum.getBackground(),imgCat.getContext().getResources().getColor(R.color.purple));
                    break;
                default: tvNum.setBackgroundColor(imgCat.getContext().getResources().getColor(R.color.red));

            }

        }
    }



    // mail item viewholder
    public class MailViewHolder extends MailBaseViewHolder{

        TextView tvTitle,tvDesc,tvContent,tvDate;
        ImageView imgUser,imgFav;



        public MailViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.item_mail_title);
            tvContent = itemView.findViewById(R.id.item_mail_content);
            tvDesc = itemView.findViewById(R.id.item_mail_description);
            tvDate = itemView.findViewById(R.id.item_mail_date);
            imgUser = itemView.findViewById(R.id.item_mail_img);
            imgFav = itemView.findViewById(R.id.item_mail_fav);


        }


        @Override
        void bindData(MailItem item) {
            setSelected(item.getSimpleItem().isRead());
            setFav(item.getSimpleItem().isFav());
            tvTitle.setText(item.getSimpleItem().getTitle());
            tvDesc.setText(item.getSimpleItem().getDescription());
            tvContent.setText(item.getSimpleItem().getContent());
            Glide.with(imgUser.getContext()).load(item.getSimpleItem().getImgUrl()).circleCrop().into(imgUser);

        }


        void setSelected(boolean isRead) {

            if (isRead) {

                tvTitle.setTypeface(Typeface.DEFAULT);
                tvDesc.setTypeface(Typeface.DEFAULT);
                tvDate.setTypeface(Typeface.DEFAULT);

            }

            else {
                tvTitle.setTypeface(Typeface.DEFAULT_BOLD);
                tvDesc.setTypeface(Typeface.DEFAULT_BOLD);
                tvDate.setTypeface(Typeface.DEFAULT_BOLD);
            }

        }
        private void setFav(boolean fav) {
            if (fav) {
                imgFav.setImageResource(R.drawable.ic_baseline_star_24);
                imgFav.setColorFilter(imgFav.getContext().getResources().getColor(R.color.yellow));
            }
            else
            {
                imgFav.setImageResource(R.drawable.ic_baseline_star_border_24);
                imgFav.setColorFilter(imgFav.getContext().getResources().getColor(R.color.light_text_sec_color));

            }

        }

    }



}
