package com.example.smartmeter.Api;
import com.example.smartmeter.Unit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api
{
    String BASE_URL = "https://vesaithonapi2.000webhostapp.com/";
    @GET("smartmeter.php")
    Call<Unit> getUnits();

}