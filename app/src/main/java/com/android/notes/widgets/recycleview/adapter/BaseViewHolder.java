package com.android.notes.widgets.recycleview.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private View itemView;
    private SparseArray<View> views;// 存放itemView中的子view

    public BaseViewHolder(View itemView) {
        super(itemView);

        this.itemView = itemView;
        views = new SparseArray<>();
    }

    /**
     * 供adapter使用,获取ViewHolder
     */
    public static <T extends BaseViewHolder> T getViewHolder(Context context, ViewGroup parent, int layoutId) {
        return (T) new BaseViewHolder(LayoutInflater.from(context).inflate(layoutId, parent, false));
    }

    /**
     * 获取子view
     */
    public <T extends View> T getView(int id) {
        View view = views.get(id);
        if (null == view) {
            view = itemView.findViewById(id);
            views.put(id, view);
        }
        return (T) view;
    }

    /**
     * 获取ItemView
     */
    public View getItemView() {
        return itemView;
    }

    /**
     * 设置点击事件监听
     */
    public BaseViewHolder setOnClickListener(int viewId, View.OnClickListener onClickListener) {
        getView(viewId).setOnClickListener(onClickListener);
        return this;
    }

    public BaseViewHolder setText(int viewId, String text) {
        ((TextView) getView(viewId)).setText(text);
        return this;
    }

    public BaseViewHolder setText(int viewId, int resId) {
        ((TextView) getView(viewId)).setText(resId);
        return this;
    }

    public BaseViewHolder setImageView(int imageViewId, int resId) {
        ((ImageView) getView(imageViewId)).setImageResource(resId);
        return this;
    }

    public BaseViewHolder setImageView(int imageViewId, Bitmap bitmap) {
        ((ImageView) getView(imageViewId)).setImageBitmap(bitmap);
        return this;
    }

}
