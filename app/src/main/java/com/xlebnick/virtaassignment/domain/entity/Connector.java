package com.xlebnick.virtaassignment.domain.entity;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel
public class Connector {
    @SerializedName("type")
    private String type;
    @SerializedName("maxKw")
    private float maxkw;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getMaxkw() {
        return maxkw;
    }

    public void setMaxkw(float maxkw) {
        this.maxkw = maxkw;
    }
}
