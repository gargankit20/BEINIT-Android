package com.beinit.ui.dashboard.fragments.discover.fragments.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beinit.R;
import com.beinit.model.Channel;
import com.common.base.widgets.adapter.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.beinit.ui.dashboard.ApiModule.CHANNEL_IMAGE_URI;

public class ChannelAdapter extends BaseRecyclerAdapter<Channel, ChannelAdapter.ChannelViewHolder> {

    public ChannelAdapter() {
        super();
    }

    @NonNull
    @Override
    public ChannelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View contactView = inflater.inflate(R.layout.item_channel, parent, false);
        final ChannelViewHolder viewHolder = new ChannelViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelViewHolder holder, int position) {
        final Channel mChannel = getItem(position);
        final Uri mUri = Uri.parse(CHANNEL_IMAGE_URI + mChannel.getId() + ".jpg");
        Picasso.get().load(mUri).fit().into(holder.imageView);
        holder.nameTextView.setText(mChannel.getName());
    }

    class ChannelViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_view)
        AppCompatImageView imageView;

        @BindView(R.id.name_text_view)
        AppCompatTextView nameTextView;

        public ChannelViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
