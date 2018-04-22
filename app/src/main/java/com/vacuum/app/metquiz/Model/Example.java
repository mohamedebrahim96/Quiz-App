package com.vacuum.app.metquiz.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("QuestionModel")
    @Expose
    private List<QuestionModel> questionModel = null;

    public List<QuestionModel> getQuestionModel() {
        return questionModel;
    }

    public void setQuestionModel(List<QuestionModel> questionModel) {
        this.questionModel = questionModel;
    }

}