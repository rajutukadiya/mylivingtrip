package com.mylivingtrip.app.retrofit

import com.google.gson.JsonObject
import com.mylivingtrip.app.activity.homescreen.response.CityResponse
import com.mylivingtrip.app.fragment.response.ListOfFightResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*


interface Api {

 /*   @FormUrlEncoded
    @POST("createuser")
    fun createUser(
            @Field("email") email:String,
            @Field("name") name:String,
            @Field("password") password:String,
            @Field("school") school:String
    ):Call<DefaultResponse>

    @FormUrlEncoded
    @POST("userlogin")
    fun userLogin(
            @Field("email") email:String,
            @Field("password") password: String
    ):Call<LoginResponse>*/

    @GET("flights/flightcity")
    fun getCityList():Call<CityResponse>


    @POST("flights/flightresult")
    fun getSerachList(@Body  jsonObject: JSONObject):Call<ListOfFightResponse>
}