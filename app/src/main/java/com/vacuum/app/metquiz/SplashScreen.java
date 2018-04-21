package com.vacuum.app.metquiz;

/**
 * Created by Home on 10/14/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vacuum.app.metquiz.NavigationDrawer.PrivacyPolicyActivity;
import com.vacuum.app.metquiz.Utils.RegisterAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static android.content.ContentValues.TAG;


public class SplashScreen extends Activity implements View.OnClickListener{

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    SharedPreferences.Editor editor;
    LinearLayout social;
    private static int SPLASH_TIME_OUT = 3000;
    String ROOT_URL;
    private EditText cardnumber,email,password,fname,lname,phone,login_cardnumber,login_password;
    TextView later,terms,terms2,register;
    Context context;
    Button buttonRegister,login_btn;
    Context mContext;
    LinearLayout layout_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        terms =  findViewById(R.id.terms);
        terms2 =  findViewById(R.id.terms2);
        cardnumber =  findViewById(R.id.card_number);
        email =  findViewById(R.id.email);
        password =  findViewById(R.id.password);
        fname =  findViewById(R.id.fname);
        lname =  findViewById(R.id.lname);
        phone =  findViewById(R.id.phone);
        buttonRegister =  findViewById(R.id.buttonRegister);
        login_btn =  findViewById(R.id.login_btn);
        layout_signup =  findViewById(R.id.layout_signup);
        register =  findViewById(R.id.register);


        login_cardnumber =  findViewById(R.id.login_cardnumber);
        login_password =  findViewById(R.id.login_password);


        mContext = this.getApplicationContext();

        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/airbnb.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build());

        later =  findViewById(R.id.later);
        context = this.getApplicationContext();
        Typeface face2 = Typeface.createFromAsset(getAssets(),
                "fonts/airbnb.ttf");
        Typeface face3 = Typeface.createFromAsset(getAssets(),
                "fonts/DK Magical Brush.otf");
        ROOT_URL = "http://192.168.1.5/";


        terms.setTypeface(face2);
        terms2.setTypeface(face2);
        later.setTypeface(face3);

        register.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
        login_btn.setOnClickListener(this);
        terms2.setOnClickListener(this);
        later.setOnClickListener(this);
    }
      

    private void skipSplash()
    {
        Intent i = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(i);
        finish();
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.buttonRegister:
                validateFields();
                break;
            case R.id.login_btn:
                login();
                break;

            case R.id.terms2:
                startActivity(new Intent(SplashScreen.this, PrivacyPolicyActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.register:
                layout_signup.setVisibility(View.VISIBLE);
                break;
            case R.id.later:
                skipSplash();
                break;
        }
    }



    private void insertUser() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        api.insertUser(
                cardnumber.getText().toString(),
                email.getText().toString(),
                password.getText().toString(),
                fname.getText().toString(),
                lname.getText().toString(),
                phone.getText().toString()
               ).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if(response.isSuccessful()) {
                    String responsse ;
                    try {
                        responsse  = response.body().string();
                        //System.out.println("====================================================");
                        //System.out.println(responsse);
                        Log.e("TAG", responsse.toString());
                        Toast.makeText(context,responsse, Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("TAG", "insertUser():: Unable to submit post to API.");
            }
        });
    }

    private void login() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        api.loging_user(
                login_cardnumber.getText().toString(),
                login_password.getText().toString()
        ).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if(response.isSuccessful()) {
                    String responsse ;
                    try {
                        responsse  = response.body().string();
                        //System.out.println("====================================================");
                        //System.out.println(responsse);
                        Toast.makeText(context,responsse, Toast.LENGTH_SHORT).show();
                        //Log.e("TAG", responsse.toString());

                        if (responsse.equals("Login Successfully")){
                            skipSplash();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("TAG", "Unable to submit post to API.");
            }
        });
    }
    private void validateFields() {
        if (cardnumber.getText().length() == 0) {
            cardnumber.setError("Empty Field");
        }else if (email.getText().length() == 0){
            email.setError("Empty Field");
        }else {
            insertUser();
        }
    }
}