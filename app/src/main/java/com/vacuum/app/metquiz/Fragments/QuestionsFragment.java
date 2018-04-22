package com.vacuum.app.metquiz.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vacuum.app.metquiz.MainActivity;
import com.vacuum.app.metquiz.Model.Example;
import com.vacuum.app.metquiz.Model.QuestionModel;
import com.vacuum.app.metquiz.R;
import com.vacuum.app.metquiz.Utils.RegisterAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.vacuum.app.metquiz.MainActivity.TAG_QUESTIONS;
import static com.vacuum.app.metquiz.MainActivity.activityTitles;
import static com.vacuum.app.metquiz.MainActivity.navItemIndex;

/**
 * Created by Home on 11/28/2017.
 */

public class QuestionsFragment extends Fragment implements View.OnClickListener{

    WebView mWebView;
    String ROOT_URL = "http://192.168.1.5/";
    List<QuestionModel> questions ;
    TextView question_count,question,text_btn1,text_btn2,text_btn3,text_btn4;
    LinearLayout buttonslayout;
    RelativeLayout result_layout;
    Button btn1,btn2,btn3,btn4;
    public static int x = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.questions_fragment, container, false);



        mWebView =  view.findViewById(R.id.webview);
        buttonslayout =  view.findViewById(R.id.buttonslayout);
        question_count =  view.findViewById(R.id.question_count);
        result_layout =  view.findViewById(R.id.result_layout);

        question =  view.findViewById(R.id.question);
        btn1 =  view.findViewById(R.id.btn1);
        btn2 =  view.findViewById(R.id.btn2);
        btn3 =  view.findViewById(R.id.btn3);
        btn4 =  view.findViewById(R.id.btn4);
        text_btn1 =  view.findViewById(R.id.text_btn1);
        text_btn2 =  view.findViewById(R.id.text_btn2);
        text_btn3 =  view.findViewById(R.id.text_btn3);
        text_btn4 =  view.findViewById(R.id.text_btn4);



        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);




        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //mWebView.clearCache(true);
        //mWebView.clearHistory();
        // mWebView.setWebChromeClient(new WebChromeClient());
        // mWebView.setWebViewClient(new WebViewClient());
        //mWebView.getSettings().setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        //mWebView.getSettings().setJavaScriptEnabled(true);
        //mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setBackgroundColor(0);

        mWebView.loadUrl("file:///android_asset/index.html");


        //====================================================================
        MainActivity.CURRENT_TAG =TAG_QUESTIONS;
        navItemIndex = 5;
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(activityTitles[5]);
//====================================================================
        setup_questions();
        return view;
    }

    private void setup_questions() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        api.getQuestions().enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                questions = new ArrayList<>();

                for (QuestionModel fruit : response.body().getQuestionModel()) {
                    questions.add(fruit);
                }

                quesion_setup();
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("TAG",t.toString());
            }
        });
    }

    private void quesion_setup() {
        buttonslayout.setVisibility(View.GONE);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (x < questions.size()) {
                    buttonslayout.setVisibility(View.VISIBLE);
                    question_count.setText( (x+1) +  "/" + String.valueOf(questions.size()));
                    question.setText(questions.get(x).getQuestion());
                    text_btn1.setText(questions.get(x).getAns1());
                    text_btn2.setText(questions.get(x).getAns2());
                    text_btn3.setText(questions.get(x).getAns3());
                    text_btn4.setText(questions.get(x).getAns4());
                    x++;
                }else {
                    result_layout.setVisibility(View.VISIBLE);
                }
            }
        }, 1000);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
                quesion_setup();
              break;
        }
    }
}