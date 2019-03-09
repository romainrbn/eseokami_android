package com.eseokami.romainrabouan.eseokamijava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class CafetAdapter extends ArrayAdapter<Item> {
    public enum RowType {
        LIST_ITEM

    }

    private LayoutInflater mInflater;

    public CafetAdapter(Context context, List<Item> items) {
        super(context, 0, items);
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getViewTypeCount() {
        return TwoTextArrayAdapter.RowType.values().length;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getViewType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItem(position).getView(mInflater, convertView);


    }

    public static class ViewHolder {
        public  View View;
    }

}
