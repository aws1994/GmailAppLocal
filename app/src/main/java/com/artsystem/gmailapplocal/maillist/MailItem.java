package com.artsystem.gmailapplocal.maillist;

import com.artsystem.gmailapplocal.data.Constant;

public class MailItem {

    private MailCategoryItem categoryItem;
    private MailSimpleItem simpleItem;

    private int type;

    public MailItem(MailCategoryItem categoryItem) {
        this.categoryItem = categoryItem;
        type = Constant.MAIL_CATEGORY_TYPE;
    }

    public MailItem(MailSimpleItem simpleItem) {
        this.simpleItem = simpleItem;
        type = Constant.MAIL_ITEM_TYPE;
    }

    public MailCategoryItem getCategoryItem() {
        return categoryItem;
    }

    public void setCategoryItem(MailCategoryItem categoryItem) {
        this.categoryItem = categoryItem;
    }

    public MailSimpleItem getSimpleItem() {
        return simpleItem;
    }

    public void setSimpleItem(MailSimpleItem simpleItem) {
        this.simpleItem = simpleItem;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
