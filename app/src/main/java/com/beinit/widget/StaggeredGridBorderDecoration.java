package com.beinit.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

public class StaggeredGridBorderDecoration extends RecyclerView.ItemDecoration {
    private int borderSize;
    private ColorDrawable borderColor;

    public StaggeredGridBorderDecoration(int borderSize, ColorDrawable borderColor) {
        this.borderSize = borderSize;
        this.borderColor = borderColor;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent,
                               RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        final RecyclerView.LayoutManager lm = parent.getLayoutManager();
        if (lm instanceof StaggeredGridLayoutManager) {
            final ViewGroup.LayoutParams lp = view.getLayoutParams();
            if (lp instanceof StaggeredGridLayoutManager.LayoutParams) {
                int spanCount = ((StaggeredGridLayoutManager) lm).getSpanCount();
                int spanIndex = ((StaggeredGridLayoutManager.LayoutParams) lp).getSpanIndex();
                int position = parent.getChildAdapterPosition(view);
                if (spanIndex == 0) {
                    outRect.left = borderSize;
                }
                if (position < spanCount) {
                    outRect.top = borderSize;
                }
                outRect.right = borderSize;
                outRect.bottom = borderSize;
            }
        } else if (lm instanceof GridLayoutManager) {
            final ViewGroup.LayoutParams lp = view.getLayoutParams();
            if (lp instanceof GridLayoutManager.LayoutParams) {
                int spanCount = ((GridLayoutManager) lm).getSpanCount();
                int spanIndex = ((GridLayoutManager.LayoutParams) lp).getSpanIndex();
                int position = parent.getChildAdapterPosition(view);
                if (spanIndex == 0) {
                    outRect.left = borderSize;
                }
                if (position < spanCount) {
                    outRect.top = borderSize;
                }
                outRect.right = borderSize;
                outRect.bottom = borderSize;
            }
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        final int childCount = parent.getChildCount();
        if (childCount == 0) {
            return;
        }
        for (int index = 0; index < childCount; index++) {
            final View child = parent.getChildAt(index);
            final ViewGroup.LayoutParams lpp = child.getLayoutParams();
            if (lpp instanceof StaggeredGridLayoutManager.LayoutParams) {
                StaggeredGridLayoutManager.LayoutParams lp = (StaggeredGridLayoutManager.LayoutParams) lpp;
                int spanIndex = lp.getSpanIndex();
                int childTop = child.getTop() - lp.topMargin;
                int childBottom = child.getBottom() + lp.bottomMargin;
                int childLeft = child.getLeft();
                int childRight = child.getRight();

                if (spanIndex == 0) {
                    int leftBorderRight = childLeft - lp.leftMargin;
                    int leftBorderLeft = leftBorderRight - borderSize;
                    borderColor.setBounds(leftBorderLeft, childTop,
                            leftBorderRight, childBottom + borderSize);
                    borderColor.draw(c);
                }
                int rightBorderLeft = childRight + lp.rightMargin;
                int rightBorderRight = rightBorderLeft + borderSize;
                borderColor.setBounds(rightBorderLeft, childTop,
                        rightBorderRight, childBottom + borderSize);
                borderColor.draw(c);
                // draw bottom border
                int bottomBorderTop = childBottom;
                int bottomBorderBottom = bottomBorderTop + borderSize;
                borderColor.setBounds(childLeft, bottomBorderTop, childRight, bottomBorderBottom);
                borderColor.draw(c);
            }else if (lpp instanceof GridLayoutManager.LayoutParams) {
                GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) lpp;
                int spanIndex = lp.getSpanIndex();
                int childTop = child.getTop() - lp.topMargin;
                int childBottom = child.getBottom() + lp.bottomMargin;
                int childLeft = child.getLeft();
                int childRight = child.getRight();

                if (spanIndex == 0) {
                    int leftBorderRight = childLeft - lp.leftMargin;
                    int leftBorderLeft = leftBorderRight - borderSize;
                    borderColor.setBounds(leftBorderLeft, childTop,
                            leftBorderRight, childBottom + borderSize);
                    borderColor.draw(c);
                }
                int rightBorderLeft = childRight + lp.rightMargin;
                int rightBorderRight = rightBorderLeft + borderSize;
                borderColor.setBounds(rightBorderLeft, childTop,
                        rightBorderRight, childBottom + borderSize);
                borderColor.draw(c);
                // draw bottom border
                int bottomBorderTop = childBottom;
                int bottomBorderBottom = bottomBorderTop + borderSize;
                borderColor.setBounds(childLeft, bottomBorderTop, childRight, bottomBorderBottom);
                borderColor.draw(c);
            }
        }
    }
}
