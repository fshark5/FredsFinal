package com.example.myapplication;

import com.google.gson.annotations.SerializedName;
public class HomeData {

    @SerializedName("bedrooms")
    public double bedrooms;

    @SerializedName("bathrooms")
    public double bathrooms;

    @SerializedName("city")
    public String city;

    @SerializedName("state")
    public String state;

    @SerializedName("zipcode")
    public String zipCode;

    @SerializedName("streetAddress")
    public String streetAddress;

    @SerializedName("homeType")
    public String homeType;

    @SerializedName("price")
    public double price;

    @SerializedName("imgSrc")
    public String imgSrc;

    public double getBedrooms(){return bedrooms;}

    public double getBathrooms() {return bathrooms;}

    public double getPrice() {return price;}

    public String getStreetAddress() {return streetAddress;}

    public String getCity() {return city;}

    public String getZipCode() {return zipCode;}
    public String getFullAddress() {return ("" + streetAddress + ", " + city + ", " + state + " " + zipCode);}

    public String getHomeType() {return homeType;}

    public String getImgSrc() {return imgSrc;}

    public void setBedrooms(double bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setBathrooms(double bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setHomeType(String homeType) {
        this.homeType = homeType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
