package com.beinit.ui.demographic.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DemographicModel implements Parcelable {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subTitle")
    @Expose
    private String subTitle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.subTitle);
    }

    public DemographicModel() {
    }

    protected DemographicModel(Parcel in) {
        this.title = in.readString();
        this.subTitle = in.readString();
    }

    public static final Parcelable.Creator<DemographicModel> CREATOR = new Parcelable.Creator<DemographicModel>() {
        @Override
        public DemographicModel createFromParcel(Parcel source) {
            return new DemographicModel(source);
        }

        @Override
        public DemographicModel[] newArray(int size) {
            return new DemographicModel[size];
        }
    };
}
