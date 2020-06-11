package com.mylivingtrip.app.retrofit;


import com.mylivingtrip.app.activity.homescreen.response.CityResponse;
import com.mylivingtrip.app.fragment.response.ListOfFightResponse;
import com.mylivingtrip.app.fragment.response.test;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiInterface {



    @POST("flights/flightresult")
    Call<ListOfFightResponse> getFightList(@Body test task);


    @GET("flights/flightcity")
    Call<CityResponse> getCityList();
}