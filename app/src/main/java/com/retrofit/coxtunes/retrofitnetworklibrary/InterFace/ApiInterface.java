package com.retrofit.coxtunes.retrofitnetworklibrary.InterFace;

import com.retrofit.coxtunes.retrofitnetworklibrary.model.contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("fetchcontact.php")
    Call<List<contact>>getContact();
}
