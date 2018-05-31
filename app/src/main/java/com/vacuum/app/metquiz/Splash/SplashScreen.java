package com.vacuum.app.metquiz.Splash;

/**
 * Created by Home on 10/14/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.vacuum.app.metquiz.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.vacuum.app.metquiz.Splash.LoginFragment.LOGIN_FRAGMENT_TAG;
import static com.vacuum.app.metquiz.Splash.SignupFragment.SIGNUP_FRAGMENT_TAG;


public class SplashScreen extends AppCompatActivity {

    public static final String MY_PREFS_NAME = "MyPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/airbnb.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
        login_fragment();
    }

    private void login_fragment() {
        Fragment fragment = new LoginFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.frame, fragment, LOGIN_FRAGMENT_TAG);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


}