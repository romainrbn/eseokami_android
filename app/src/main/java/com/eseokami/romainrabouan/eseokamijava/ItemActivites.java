package com.eseokami.romainrabouan.eseokamijava;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivites implements Item {
    public final String nom;
    public final int image;
    public final String description;

    public ItemActivites(String nom, int image, String description) {
        this.nom = nom;
        this.image = image;
        this.description = description;
    }

    @Override
    public int getViewType() {
        return ActivitesAdapter.RowType.LIST_ITEM.ordinal();
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.activite_item, null);
            view.setOnClickListener(null);

        } else {
            view = convertView;
        }

        TextView text1 = (TextView) view.findViewById(R.id.nom_activite_label);
        ImageView imageView = (ImageView) view.findViewById(R.id.act_icone);
        TextView text2 = (TextView) view.findViewById(R.id.detailTVActivites);


        text1.setText(nom);
        text2.setText(description);
        imageView.setImageResource(image);


        return view;
    }
}
