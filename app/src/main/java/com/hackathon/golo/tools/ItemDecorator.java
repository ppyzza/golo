package com.hackathon.golo.tools;


import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.golo.R;


public class ItemDecorator extends RecyclerView.ItemDecoration {
    private final static int PADDING_TOP_BOTTOM_IN_DIPS = 8;
    private final static int PADDING_RIGHT_LEFT_IN_DIPS = 8;
    private final int mPaddingTopAndBottom;
    private final int mPaddingRightAndLeft;
    private Context mContext;

    public ItemDecorator(@NonNull Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        mPaddingTopAndBottom = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, PADDING_TOP_BOTTOM_IN_DIPS, metrics);
        mPaddingRightAndLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, PADDING_RIGHT_LEFT_IN_DIPS, metrics);
        mContext = context;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        final int itemPosition = parent.getChildAdapterPosition(view);
        if (itemPosition == RecyclerView.NO_POSITION) {
            return;
        }
//        if (itemPosition == 0) {
//            outRect.top = mPaddingTopAndBottom;
//            outRect.left = mPaddingRightAndLeft;
//
//        }

        outRect.right = mPaddingRightAndLeft;
        outRect.left = mPaddingRightAndLeft;

    }
}
