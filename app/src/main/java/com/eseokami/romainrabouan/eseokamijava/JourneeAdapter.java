package com.eseokami.romainrabouan.eseokamijava;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

public class JourneeAdapter extends ArrayAdapter<Item> {
    public enum RowType {
        LIST_ITEM

    }

    private LayoutInflater mInflater;

    public JourneeAdapter(Context context, List<Item> items) {

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
