package com.android.notes.base.adapter;

import android.content.Context;

import java.util.List;

/**
 * 多种布局
 *
 * @param <T>
 */
public abstract class MultiLayoutBaseAdapter<T> extends BaseAdapter<T> {

    public MultiLayoutBaseAdapter(Context context, List<T> data, int[] layoutIds) {
        super(context, data, layoutIds);
    }

    @Override
    public int getItemViewType(int position) {
        return getItemType(position);
    }

    @Override
    protected void onBindData(BaseViewHolder baseHolder, T t, int position) {
        onBinds(baseHolder, t, position, getItemViewType(position));
    }

    /**
     * 子类实现得到具体的子类布局的方法
     */
    public abstract int getItemType(int position);

    /**
     * 子类实现对不同的item进行操作
     */
    protected abstract void onBinds(BaseViewHolder baseHolder, T t, int position, int itemViewType);

}
