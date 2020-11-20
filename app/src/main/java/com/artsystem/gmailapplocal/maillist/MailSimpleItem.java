package com.artsystem.gmailapplocal.maillist;

public class MailSimpleItem {

    private int id;
    private String title,content,description,sentMail,sentUserName;
    private int imgUrl;
    private boolean isFav = false,isRead=false;


    public MailSimpleItem() {
    }

    public MailSimpleItem(int id, String title, String content, String description, String sentMail, String sentUserName, int imgUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.description = description;
        this.sentMail = sentMail;
        this.sentUserName = sentUserName;
        this.imgUrl = imgUrl;
    }

    public MailSimpleItem(int id, String title, String content, String description, String sentMail, String sentUserName, int imgUrl,boolean isRead) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.description = description;
        this.sentMail = sentMail;
        this.sentUserName = sentUserName;
        this.imgUrl = imgUrl;
        this.isRead = isRead;
    }

    public MailSimpleItem(int id, String title, String description, int imgUrl, String Contentz) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.content = Contentz;
    }


    public MailSimpleItem(int id, String title, String description, int imgUrl, String Contentz,boolean isRead) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.content = Contentz;
        this.isRead = isRead;
    }

    public MailSimpleItem(int id, String title, String description, int imgUrl, String Contentz,boolean isRead,boolean isFav) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.content = Contentz;
        this.isRead = isRead;
        this.isFav = isFav;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSentMail() {
        return sentMail;
    }

    public void setSentMail(String sentMail) {
        this.sentMail = sentMail;
    }

    public String getSentUserName() {
        return sentUserName;
    }

    public void setSentUserName(String sentUserName) {
        this.sentUserName = sentUserName;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }


    public boolean isFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
