package com.artsystem.gmailapplocal.navigation;

public class MenuItem {

    private int icon ;
    private String title;
    private boolean isSelected = false;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getNumNotification() {
        return numNotification;
    }

    public void setNumNotification(int numNotification) {
        this.numNotification = numNotification;
    }

    private int numNotification = 0;

    public MenuItem(int drawable, String title, boolean isSelected) {
        this.icon = drawable;
        this.title = title;
        this.isSelected = isSelected;
    }



    public MenuItem(int icon, String title, boolean isSelected, int numNotification) {
        this.icon = icon;
        this.title = title;
        this.isSelected = isSelected;
        this.numNotification = numNotification;
    }

    public int getDrawable() {
        return icon;
    }

    public void setDrawable(int drawable) {
        this.icon = drawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
