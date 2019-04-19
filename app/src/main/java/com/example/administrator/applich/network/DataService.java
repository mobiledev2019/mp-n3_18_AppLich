package com.example.administrator.applich.network;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DataService {
    @GET("horoscope.php?")
    Call<JsonElement>getCungHoangDao(@Query("c") String c, @Query("m") String m, @Query("z_id") String z_id, @Query("date") String date);
}
