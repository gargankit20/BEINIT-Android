
package com.beinit.model;

import com.squareup.moshi.Json;

import java.util.List;

public class Category {
    @Json(name = "id")
    private Integer id;
    @Json(name = "name")
    private String name;
    @Json(name = "sub-categories")
    private List<SubCategory> subCategories = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
