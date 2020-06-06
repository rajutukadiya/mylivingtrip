package com.mylivingtrip.app.retrofit;


import com.mylivingtrip.app.fragment.response.ListOfFightResponse;
import com.mylivingtrip.app.fragment.response.test;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ApiInterface {



    @POST("http://mylivingtrip.com/travel/api/flights/flightresult")
    Call<ListOfFightResponse> getFightList(@Body test task);


}