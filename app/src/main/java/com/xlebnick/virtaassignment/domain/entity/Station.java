package com.xlebnick.virtaassignment.domain.entity;


import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XlebNick for VirtaAssignment.
 */

@Parcel
public class Station {

    @SerializedName("id")
    private int id;
    @SerializedName("latitude")
    private double latitude;
    @SerializedName("longitude")
    private double longitude;
    @SerializedName("name")
    private String name;
    @SerializedName("city")
    private String city;
    @SerializedName("provider")
    private String provider;
    @SerializedName("evses")
    private List<Evses> evses;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        return getId() == station.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Evses> getEvses() {
        return evses;
    }

    public void setEvses(List<Evses> evses) {
        this.evses = evses;
    }

    public List<Connector> getAllConnectors() {
        List<Connector> connectors = new ArrayList<>();
        for (Evses evse : evses) {
            connectors.addAll(evse.getConnectors());
        }
        return connectors;
    }
}
