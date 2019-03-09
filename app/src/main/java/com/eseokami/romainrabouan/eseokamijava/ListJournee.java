package com.eseokami.romainrabouan.eseokamijava;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListJournee implements Item {
    public final String str1;
    public final String str2;
    public final String str3;
    public final String str4;


    public ListJournee(String text1, String text2, String text3, String text4) {
        this.str1 = text1;
        this.str2 = text2;
        this.str3 = text3;
        this.str4 = text4;
    }

    @Override
    public int getViewType() {
        return TwoTextArrayAdapter.RowType.LIST_ITEM.ordinal();
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.row_activites, null);
            view.setOnClickListener(null);

        } else {
            view = convertView;
        }

        TextView text1 = (TextView) view.findViewById(R.id.nom_label);
        TextView text2 = (TextView) view.findViewById(R.id.detail_label);
        TextView text3 = (TextView) view.findViewById(R.id.heure_label);
        TextView text4 = (TextView) view.findViewById(R.id.lieu_label);

        text1.setText(str1);
        text2.setText(str2);
        text3.setText(str3);
        text4.setText(str4);



        return view;
    }
}
