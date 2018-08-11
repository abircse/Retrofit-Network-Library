package com.retrofit.coxtunes.retrofitnetworklibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.retrofit.coxtunes.retrofitnetworklibrary.InterFace.ApiInterface;
import com.retrofit.coxtunes.retrofitnetworklibrary.adapter.recyclearAdapter;
import com.retrofit.coxtunes.retrofitnetworklibrary.apiclient.apiclient;
import com.retrofit.coxtunes.retrofitnetworklibrary.model.contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private recyclearAdapter adapter;
    private List<contact> contacts;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.myrecycle);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //--------make request---------//
        apiInterface = apiclient.getApiClient().create(ApiInterface.class);
        Call<List<contact>> call = apiInterface.getContact();

        //-------methord for get responce----//
        call.enqueue(new Callback<List<contact>>() {
            @Override
            public void onResponse(Call<List<contact>> call, Response<List<contact>> response) {


                //------200 meaance positive RESPONSE or you can write isSuccessfull methord-----//
                if (response.code() == 200)
                {
                    contacts = response.body();
                    adapter = new recyclearAdapter(contacts);
                    recyclerView.setAdapter(adapter);


                }



            }

            @Override
            public void onFailure(Call<List<contact>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "ERROR IS "+t, Toast.LENGTH_LONG).show();
            }
        });

    }
}
