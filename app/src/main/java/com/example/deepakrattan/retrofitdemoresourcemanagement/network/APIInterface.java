package com.example.deepakrattan.retrofitdemoresourcemanagement.network;


import com.example.deepakrattan.retrofitdemoresourcemanagement.model.LoginData;
import com.example.deepakrattan.retrofitdemoresourcemanagement.model.LoginResponse;
import com.example.deepakrattan.retrofitdemoresourcemanagement.model.ProjectListResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("AccountAPI/GetLoginUser")
    Call<LoginResponse> getLogin(@Body LoginData loginData);

    //Inside the @Get annotation we need to pass the end point
    // to get the JSON Data
    @GET("ProjectAPI/GetProjectListing")
    Call<ProjectListResponse> getProjects();


}
