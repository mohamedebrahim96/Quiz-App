package com.vacuum.app.metquiz.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.vacuum.app.metquiz.MainActivity;
import com.vacuum.app.metquiz.R;

import static com.vacuum.app.metquiz.MainActivity.TAG_QUESTIONS;
import static com.vacuum.app.metquiz.MainActivity.activityTitles;
import static com.vacuum.app.metquiz.MainActivity.navItemIndex;

/**
 * Created by Home on 11/28/2017.
 */

public class Questions extends Fragment {

    WebView mWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.questions_fragment, container, false);


        mWebView = (WebView) view.findViewById(R.id.webview);


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
        return view;
    }
}