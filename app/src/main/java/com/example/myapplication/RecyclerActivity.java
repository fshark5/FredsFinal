// Frederick Sharkevich
package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerActivity extends AppCompatActivity {

    private HomeAdapter adapter;
    private RecyclerView homeList;
    private String apiKey = "24ff877e2bmsh7b0f3c8f0ab0a3fp1f6e79jsn2cdf5edd3f04";
    ProgressDialog progressDialog;
    public String location;

    private HomeData homeData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        Intent navIntent = getIntent();
        location = navIntent.getStringExtra("location");


        ProgressDialog progressDoalog = new ProgressDialog(RecyclerActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        // Create a reference for the RetrofitInstance interface
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<ApiResponse> call = service.getAllHomes( apiKey , location);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse apiResponse = response.body();

                    if (apiResponse.getResults() != null) {
                        progressDoalog.dismiss();
                        generateDataList(apiResponse.getResults());
                    } else {
                        Log.e("Error", "Response results are null");
                        // Handle the case where results are null
                    }
                } else {
                    try {
                        // Log the error response body as a string
                        Log.e("Error Response", response.errorBody() != null ? response.errorBody().string() : "Unknown error");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                if (response.isSuccessful()) {
//                    // Log the response body or perform further processing
//                    Log.d("Response Body", response.body().toString());
//
//                    progressDoalog.dismiss();
//
//                    // Assuming ApiResponse has a method to get the list of HomeData
//                    generateDataList(response.body().getResults());
//                } else {
//                    // Log the error response
//                    Log.e("Error Response", response.errorBody().toString());
//                }
                }}

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("API Call Failure", "Error: " + t.getMessage(), t);
                progressDoalog.dismiss();
                Toast.makeText(RecyclerActivity.this,
                        "Something went wrong...Please try later!", Toast.LENGTH_LONG).show();
            }
        });



    }
    private void generateDataList(List<HomeData> photoList) {

//        photoList.size()
//        if(photoList != null){
//            for (HomeData currentHomeData : photoList) {
//                Log.d("abc", currentHomeData.getFullAddress());
//            }
//        }


        homeList = findViewById(R.id.homeRecyclerView);
        adapter = new HomeAdapter(this, photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecyclerActivity.this);
        homeList.setLayoutManager(layoutManager);
        homeList.setAdapter(adapter);
    }

    {
}}
