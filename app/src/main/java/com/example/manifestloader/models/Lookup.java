package com.example.manifestloader.models;

import com.google.gson.annotations.SerializedName;

public class Lookup {

    public String getHostname() {
        return mHostname;
    }

    public String getKind() {
        return mKind;
    }

    public String getListType() {
        return mListType;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setHostname(String hostname) {
        this.mHostname = hostname;
    }

    public void setKind(String kind) {
        this.mKind = kind;
    }

    public void setListType(String listType) {
        this.mListType = listType;
    }

    public void setCreatedAt(String createdAt) {
        this.mCreatedAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.mUpdatedAt = updatedAt;
    }

    public long id;
    @SerializedName("hostname")
    private String mHostname;
    @SerializedName("kind")
    private String mKind;
    @SerializedName("list")
    private String mListType;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("updated_at")
    private String mUpdatedAt;

//    "id": 49,
//    "hostname": "/billing",
//    "kind": "keyword",
//    "created_at": "2018-08-03T08:11:56.000Z",
//    "updated_at": "2018-08-03T08:11:56.000Z"
}
