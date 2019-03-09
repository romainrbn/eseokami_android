package com.eseokami.romainrabouan.eseokamijava;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class HeaderActivites implements Item {

    public final String periode;

    public HeaderActivites(String periode) {
        this.periode = periode;
    }


    @Override
    public int getViewType() {
        return ActivitesAdapter.RowType.HEADER_ITEM.ordinal();
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.act_header, null);
            view.setOnClickListener(null);
            // Initialisation
        } else {
            view = convertView;
        }

        TextView periodeTV = (TextView) view.findViewById(R.id.header_act_tv);

        periodeTV.setText(periode);

        return view;
    }

}
