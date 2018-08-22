
package com.beinit.model;

import com.squareup.moshi.Json;

public class ChannelAndCategoriesModel {
    @Json(name = "status")
    private Boolean status;
    @Json(name = "data")
    private Data data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
