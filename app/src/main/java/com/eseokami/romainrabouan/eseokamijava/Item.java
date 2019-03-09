package com.eseokami.romainrabouan.eseokamijava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.sql.Array;
import java.util.List;

public interface Item {
    public int getViewType();
    public View getView(LayoutInflater inflater, View convertView);
}


