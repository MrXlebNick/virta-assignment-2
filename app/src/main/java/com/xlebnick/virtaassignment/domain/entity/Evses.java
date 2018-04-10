package com.xlebnick.virtaassignment.domain.entity;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;


@Parcel
public class Evses {
    @SerializedName("id")
    private int id;
    @SerializedName("connectors")
    private List<Connector> connectors;
    @SerializedName("groupName")
    private String groupname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Connector> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<Connector> connectors) {
        this.connectors = connectors;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
}
