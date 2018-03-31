package com.vacuum.app.metquiz.Model;

import io.realm.RealmObject;

/**
 * Created by Home on 9/21/2017.
 */

public class Person extends RealmObject {

    private String tableAndId;
    String Name;
    String job;
    String imageLink;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getTableAndId() {
        return tableAndId;
    }

    public void setTableAndId(String tableAndId) {
        this.tableAndId = tableAndId;
    }
}