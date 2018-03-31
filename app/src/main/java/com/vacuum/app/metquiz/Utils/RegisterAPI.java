package com.vacuum.app.metquiz.Utils;

import android.widget.EditText;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Home on 3/27/2018.
 */

public interface RegisterAPI {

    @POST("/quiz/insert.php")
    @FormUrlEncoded
    Call<ResponseBody> insertUser2(@Field("cardnumber") String card_number,
                                   @Field("email") String email,
                                   @Field("password") String password,
                                   @Field("fname") String fname,
                                   @Field("lname") String lname,
                                   @Field("phone") String phone);

    @POST("/quiz/login.php")
    @FormUrlEncoded
    Call<ResponseBody> loging_user(@Field("cardnumber") String card_number,
                                   @Field("password") String password);
}
