package com.artsystem.gmailapplocal.navigation;

import com.artsystem.gmailapplocal.data.Constant;

public class NavItem {



    public NavItem(MenuItem menuItem) {
        this.menuItem = menuItem;
        type = Constant.NAV_MENU_TYPE;
    }

    public NavItem(LabelItem labelItem) {
        this.labelItem = labelItem;
        type = Constant.NAV_TEXT_TYPE;
    }

    private int type;
    private MenuItem menuItem;
    private LabelItem labelItem;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public LabelItem getLabelItem() {
        return labelItem;
    }

    public void setLabelItem(LabelItem labelItem) {
        this.labelItem = labelItem;
    }
}
