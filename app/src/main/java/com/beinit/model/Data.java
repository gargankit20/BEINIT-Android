
package com.beinit.model;

import java.util.List;
import com.squareup.moshi.Json;

public class Data {

    @Json(name = "0")
    private List<Object> _0 = null;
    @Json(name = "channel")
    private List<Channel> channel = null;
    @Json(name = "categories")
    private List<Category> categories = null;

    public List<Object> get0() {
        return _0;
    }

    public void set0(List<Object> _0) {
        this._0 = _0;
    }

    public List<Channel> getChannel() {
        return channel;
    }

    public void setChannel(List<Channel> channel) {
        this.channel = channel;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
