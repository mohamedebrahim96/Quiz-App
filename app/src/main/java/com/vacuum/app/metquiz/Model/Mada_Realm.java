package com.vacuum.app.metquiz.Model;

import io.realm.RealmObject;

/**
 * Created by Home on 10/15/2017.
 */

public class Mada_Realm extends RealmObject {

    String mada_num,mada_title,comments,mada_update,comments_links,mada_old_links;
    public String uid;
    public Mada_Realm()
    {

    }
    public Mada_Realm(String mada_num,String mada_title,String comments,String mada_update,String comments_links,String mada_old_links)
    {
        this.mada_num=mada_num;
        this.mada_title=mada_title;
        this.comments=comments;
        this.mada_update=mada_update;
        this.comments_links=comments_links;
        this.mada_old_links=mada_old_links;
    }

    public String getMada_num() {
        return mada_num;
    }

    public void setMada_num(String mada_num) {
        this.mada_num = mada_num;
    }

    public String getMada_title() {
        return mada_title;
    }

    public void setMada_title(String mada_title) {
        this.mada_title = mada_title;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getMada_update() {
        return mada_update;
    }

    public void setMada_update(String mada_update) {
        this.mada_update = mada_update;
    }

    public String getComments_links() {
        return comments_links;
    }

    public void setComments_links(String comments_links) {
        this.comments_links = comments_links;
    }

    public String getMada_old_links() {
        return mada_old_links;
    }

    public void setMada_old_links(String mada_old_links) {
        this.mada_old_links = mada_old_links;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
