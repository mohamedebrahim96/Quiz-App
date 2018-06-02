package com.vacuum.app.metquiz.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("exam_name")
    @Expose
    private String exam_name = null;

    @SerializedName("start_date")
    @Expose
    private String start_date = null;

    @SerializedName("timer")
    @Expose
    private int timer ;

    @SerializedName("points")
    @Expose
    private int points ;

    @SerializedName("QuestionModel")
    @Expose
    private List<QuestionModel> questionModel = null;

    public List<QuestionModel> getQuestionModel() {
        return questionModel;
    }

    public void setQuestionModel(List<QuestionModel> questionModel) {
        this.questionModel = questionModel;
    }

    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}