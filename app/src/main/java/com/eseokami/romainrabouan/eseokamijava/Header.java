package com.eseokami.romainrabouan.eseokamijava;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Header implements Item {
    private final String name;
    private final String description;
    private final String kami;

    public Header(String name, String description, String kami) {
        this.name = name;
        this.description = description;
        this.kami = kami;
    }

    @Override
    public int getViewType() {
        return TwoTextArrayAdapter.RowType.HEADER_ITEM.ordinal();
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.header, null);
            view.setOnClickListener(null);
            // Initialisation
        } else {
            view = convertView;
        }

        TextView text = (TextView) view.findViewById(R.id.separator);
        TextView desc = (TextView) view.findViewById(R.id.desc_module);
        TextView kam = (TextView) view.findViewById(R.id.kamiTV);
        text.setText(name);
        desc.setText(description);
        kam.setText(kami);

        return view;
    }
}
