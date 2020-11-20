package com.artsystem.gmailapplocal.maillist;

public class MailCategoryItem {

    private int icon;
    private String title,desc,content;
    private String color;
    private int numNotif;

    public MailCategoryItem(int icon, String title, String desc, String content, String color, int numNotif) {
        this.icon = icon;
        this.title = title;
        this.desc = desc;
        this.content = content;
        this.color = color;
        this.numNotif = numNotif;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumNotif() {
        return numNotif;
    }

    public void setNumNotif(int numNotif) {
        this.numNotif = numNotif;
    }
}
