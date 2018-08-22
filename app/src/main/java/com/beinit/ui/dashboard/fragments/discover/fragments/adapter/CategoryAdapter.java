package com.beinit.ui.dashboard.fragments.discover.fragments.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beinit.R;
import com.beinit.model.SubCategory;
import com.common.base.widgets.adapter.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.beinit.ui.dashboard.ApiModule.SUB_CATEGORY_IMAGE_URI;

public class CategoryAdapter
        extends BaseRecyclerAdapter<SubCategory, CategoryAdapter.CategoryViewHolder> {

    public CategoryAdapter() {
        super();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View contactView = inflater.inflate(R.layout.item_category, parent, false);
        final CategoryViewHolder viewHolder = new CategoryViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        final SubCategory mCategory = getItem(position);
        final Uri mUri = Uri.parse(SUB_CATEGORY_IMAGE_URI + mCategory.getId() + ".jpg");
        Picasso.get().load(mUri).fit().into(holder.imageView);
        holder.nameTextView.setText(mCategory.getName());
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_view)
        AppCompatImageView imageView;

        @BindView(R.id.name_text_view)
        AppCompatTextView nameTextView;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}