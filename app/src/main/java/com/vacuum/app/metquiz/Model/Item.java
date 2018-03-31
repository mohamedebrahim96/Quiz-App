package com.vacuum.app.metquiz.Model;

/**
 * Created by Home on 2017-08-23.
 */

public class Item {
    public String mada_title, mada_num, update,comments,imageLink;
    int id,image;

    public Item(){
    }
    public Item(String mada_title){
        this.mada_title = mada_title;
    }

    public Item(String mada_num,String mada_title){
        this.mada_title = mada_title;
        this.mada_num = mada_num;

    }
    public Item(String mada_title,int image)
    {
        this.mada_title = mada_title;
        this.image = image;
    }
    public Item(int id,String mada_title,String mada_num,String update )
    {
        this.mada_title=mada_title;
        this.mada_num=mada_num;
        this.update=update;
        this.id=id;
    }
    public Item(String mada_title,String mada_num,String imageLink )
    {
        this.mada_title=mada_title;
        this.mada_num=mada_num;
        this.imageLink=imageLink;
    }
    public Item(String mada_title,String mada_num,int image)
    {
        this.mada_title=mada_title;
        this.mada_num=mada_num;
        this.image=image;
    }

    public String getMada_title() {
        return mada_title;
    }

    public String getMada_num() {
        return mada_num;
    }

    public void setMada_num(int id,String mada_num) {
        this.mada_num = mada_num;
        this.id = id;

    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(int id,String update) {
        this.update = update;
        this.id = id;

    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMada_title(String mada_title) {
        this.mada_title = mada_title;
    }

    public void setMada_num(String mada_num) {
        this.mada_num = mada_num;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getImageLink() {
        return imageLink;
    }
    public Item (String o,int n,int s) {
        imageLink = o;
    }

    public void setImageLink(String imageLink2) {
        this.imageLink = imageLink2;
    }
}
