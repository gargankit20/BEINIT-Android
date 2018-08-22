package com.beinit.ui.dashboard.fragments.discover.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.beinit.R;
import com.beinit.base.AppBaseFragment;
import com.beinit.model.Category;
import com.beinit.ui.dashboard.fragments.discover.fragments.adapter.CategoryAdapter;
import com.beinit.ui.dashboard.fragments.discover.fragments.adapter.SectionedGridRecyclerViewAdapter;
import com.beinit.widget.StaggeredGridBorderDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CategoriesFragment extends AppBaseFragment {
    @BindView(R.id.categories_recycler_view)
    RecyclerView mCategoriesRecyclerView;

    @Override
    protected int layoutId() {
        return R.layout.fragment_categories;
    }

    @Override
    protected void injectToActivityComponent() {

    }

    @Override
    public void onShow() {

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void setData(List<Category> categories) {
        final GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mCategoriesRecyclerView.setLayoutManager(layoutManager);
        CategoryAdapter mAdapter = new CategoryAdapter();
        List<SectionedGridRecyclerViewAdapter.Section> sections = new ArrayList<>();
        int offset = 0;
        for (Category category : categories) {
            mAdapter.addItems(category.getSubCategories());
            final SectionedGridRecyclerViewAdapter.Section mSection =
                    new SectionedGridRecyclerViewAdapter.Section(offset, category.getName());
            sections.add(mSection);
            offset = mAdapter.getItemCount();
        }
        SectionedGridRecyclerViewAdapter mSectionedAdapter = new
                SectionedGridRecyclerViewAdapter(getActivity(),
                R.layout.section,
                R.id.section_text,
                mCategoriesRecyclerView, mAdapter);
        SectionedGridRecyclerViewAdapter.Section[] dummy = new SectionedGridRecyclerViewAdapter.Section[sections.size()];
        final SectionedGridRecyclerViewAdapter.Section[] array = sections.toArray(dummy);
        mSectionedAdapter.setSections(array);
        mCategoriesRecyclerView.setAdapter(mSectionedAdapter);
        final int size = getResources().getDimensionPixelSize(R.dimen.spacing_small_tiny);
        final ColorDrawable drawable = new ColorDrawable(Color.BLACK);
        final StaggeredGridBorderDecoration decoration = new StaggeredGridBorderDecoration(size, drawable);
        mCategoriesRecyclerView.addItemDecoration(decoration);
    }
}
