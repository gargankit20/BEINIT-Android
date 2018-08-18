package com.beinit.ui.demographic;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.beinit.ui.demographic.adapter.DemographicTitleAdapter;
import com.beinit.ui.demographic.model.DemographicModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class DemographicModule {
    final FragmentManager mFragmentManager;
    final Context mContext;

    public DemographicModule(final Context mContext, final FragmentManager mFragmentManager) {
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
    }

    @Provides
    @DemographicScope
    List<DemographicModel> provideDemographicModel() {
        List<DemographicModel> mData = new ArrayList<>();
        try {
            final InputStream inputStream = mContext.getAssets().open("demographic_title.json");
            final int size = inputStream.available();
            final byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            final String json = new String(buffer, "UTF-8");
            final Gson mGson = new Gson();
            final Type mType = new TypeToken<ArrayList<DemographicModel>>() {
            }.getType();
            mData = mGson.fromJson(json, mType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mData;
    }

    @Provides
    @DemographicScope
    DemographicTitleAdapter provideDemographicTitleAdapter(final List<DemographicModel> mModels) {
        return new DemographicTitleAdapter(mFragmentManager, mModels);
    }

}
