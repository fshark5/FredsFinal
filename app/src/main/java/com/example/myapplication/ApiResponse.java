package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @SerializedName("results")
    public List<HomeData> results;

    @SerializedName("totalPages")
    public int totalPages;

    @SerializedName("totalResultCount")
    public int totalResultCount;

    public List<HomeData> getResults() {
        return results;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalResultCount() {
        return totalResultCount;
    }
}