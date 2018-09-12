package com.example.manifestloader.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OuterObject {

    public long getId() {
        return id;
    }

    public String getName() {
        return mName;
    }

    public String getStartsAt() {
        return mStartsAt;
    }

    public String getEndsAt() {
        return mEndsAt;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public String getDeletedAt() {
        return mDeletedAt;
    }

    public String getInternalId() {
        return mInternalId;
    }

    public int getNamingCounter() {
        return mNamingCounter;
    }

    public long getAuthorId() {
        return mAuthorId;
    }

    public boolean isActive() {
        return mActive;
    }

    public String getArchivedAt() {
        return mArchivedAt;
    }

    public boolean isArchived() {
        return mArchived;
    }

    public int getParticipantsCount() {
        return mParticipantsCount;
    }

    public List<TLookup> getWhitelist() {
        return mWhitelist;
    }

    public List<TLookup> getBlacklist() {
        return mBlacklist;
    }

    public long id;
    @SerializedName("name")
    private String mName;
    @SerializedName("starts_at")
    private String mStartsAt;
    @SerializedName("ends_at")
    private String mEndsAt;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("updated_at")
    private String mUpdatedAt;
    @SerializedName("deleted_at")
    private String mDeletedAt;
    @SerializedName("internal_id")
    private String mInternalId;
    @SerializedName("naming_counter")
    private int mNamingCounter;
    @SerializedName("author_id")
    private long mAuthorId;
    @SerializedName("active")
    private boolean mActive;
    @SerializedName("archived_at")
    private String mArchivedAt;
    @SerializedName("is_archived")
    private boolean mArchived;
    @SerializedName("participants_count")
    private int mParticipantsCount;
    @SerializedName("whitelist")
    private List<TLookup> mWhitelist;
    @SerializedName("blacklist")
    private List<TLookup> mBlacklist;

//    "id": 33,
//    "name": "Test Roehnisch",
//    "starts_at": "2018-08-21T00:00:00.000Z",
//    "ends_at": "2019-08-28T00:00:00.000Z",
//    "created_at": "2018-08-21T09:21:54.000Z",
//    "updated_at": "2018-08-21T09:22:07.000Z",
//    "deleted_at": null,
//    "internal_id": "TR",
//    "naming_counter": 4,
//    "author_id": 5,
//    "active": true,
//    "archived_at": null,
//    "is_archived": false,
//    "participants_count": 3,
//    "whitelist": [
//    "blacklist": [
}
