package com.beinit.ui.dashboard;

import com.beinit.network.ApiService;
import com.squareup.moshi.Moshi;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class ApiModule {
    private final HttpUrl PRODUCTION_API_URL = HttpUrl.parse("https://api.cedricm.com/api/");
    public final static String CHANNEL_IMAGE_URI = "https://api.cedricm.com/media/channels/";
    public final static String SUB_CATEGORY_IMAGE_URI = "https://api.cedricm.com/media/sub-categories/";

    @Provides
    @DashboardScope
    HttpUrl provideBaseUrl() {
        return PRODUCTION_API_URL;
    }

    @Provides
    @DashboardScope
    Moshi provideMoshi() {
        return new Moshi.Builder().build();
    }

    @Provides
    @DashboardScope
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @DashboardScope
    Retrofit provideRetrofit(HttpUrl mBaseUrl, OkHttpClient mClient, Moshi mMoshi) {
        return new Retrofit.Builder()
                .client(mClient)
                .baseUrl(mBaseUrl)
                .addConverterFactory(MoshiConverterFactory.create(mMoshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @DashboardScope
    ApiService provideGithubService(Retrofit mRetrofit) {
        return mRetrofit.create(ApiService.class);
    }
}
