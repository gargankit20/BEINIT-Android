package com.beinit.network;

import com.beinit.model.ChannelAndCategoriesModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("category/discover?PHPSESSID=n56r3oc2jh8grrg578sefevrn7")
    Observable<ChannelAndCategoriesModel> getChannelAndCategoriesModelData();
}
