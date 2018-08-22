package com.common.base.widgets.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends
        RecyclerView.Adapter<VH> {

    private List<T> mDataSet;

    protected BaseRecyclerAdapter() {
        mDataSet = new ArrayList<>();
    }

    BaseRecyclerAdapter(final List<T> mDataSet) {
        this.mDataSet = mDataSet;
    }

    public void clean() {
        mDataSet.clear();
    }

    public void resetItems(@NonNull final List<T> newDataSet) {
        mDataSet.clear();
        addItems(newDataSet);
    }

    public void addItems(@NonNull final List<T> newDataSetItems) {
        mDataSet.addAll(newDataSetItems);
        notifyDataSetChanged();
    }

    public void addItem(final T mItem) {
        if (!mDataSet.contains(mItem)) {
            mDataSet.add(mItem);
            notifyItemInserted(mDataSet.size() - 1);
        }
    }

    private void removeItem(final T mItem) {
        int indexOfItem = mDataSet.indexOf(mItem);
        if (indexOfItem != -1) {
            this.mDataSet.remove(indexOfItem);
            notifyItemRemoved(indexOfItem);
        }
    }

    public void removeItem(final int mPosition) {
        final T mdata = mDataSet.get(mPosition);
        if (mdata != null) {
            this.mDataSet.remove(mdata);
            notifyItemRemoved(mPosition);
        }
    }

    public T getItem(final int mIndex) {
        if (mDataSet != null && mDataSet.get(mIndex) != null) {
            return mDataSet.get(mIndex);
        } else {
            throw new IllegalArgumentException("Item with index " + mIndex + " doesn't exist, mDataSet is " + mDataSet);
        }
    }

    protected List<T> getDataSet() {
        return mDataSet;
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}