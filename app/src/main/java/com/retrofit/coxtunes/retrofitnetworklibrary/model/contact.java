package com.retrofit.coxtunes.retrofitnetworklibrary.model;

import com.google.gson.annotations.SerializedName;

public class contact {

    @SerializedName("name")
    private String Name;

    @SerializedName("email")
    private String Email;

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }
}
