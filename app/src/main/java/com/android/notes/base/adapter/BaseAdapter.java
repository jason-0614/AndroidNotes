package com.android.notes.base.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * 单一布局
 *
 * @param <T>
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    protected Context context;
    private List<T> data;
    private int[] layoutIds;

    /**
     * 单一布局时的构造函数
     */
    public BaseAdapter(Context context, List<T> data, int layoutId) {
        this.context = context;
        this.data = data;
        this.layoutIds = new int[]{layoutId};
    }

    /**
     * 多种布局时的构造函数
     */
    protected BaseAdapter(Context context, List<T> data, int[] layoutIds) {
        this.context = context;
        this.data = data;
        this.layoutIds = layoutIds;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    /**
     * 使用一种布局时的viewType默认为0,使用多种布局时的viewType需要指定
     */
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return BaseViewHolder.getViewHolder(context, viewGroup, layoutIds[viewType]);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseHolder, int position) {
        onBindData(baseHolder, data.get(position), position);
    }

    @Override
    public int getItemCount() {
        return null == data ? 0 : data.size();
    }

    /**
     * 让子类实现具体的数据绑定方法
     */
    protected abstract void onBindData(BaseViewHolder baseHolder, T t, int position);

}
