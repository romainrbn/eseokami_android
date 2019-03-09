package com.eseokami.romainrabouan.eseokamijava;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListCafet implements Item {
    public final String name;
    public final int image;

    public ListCafet(String name, int image) {
        this.name = name;
        this.image = image;
    }

    @Override
    public int getViewType() {
        return 0;
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.cafet_item, null);
            view.setOnClickListener(null);
        } else {
            view = convertView;
        }

        TextView nameTextView = (TextView) view.findViewById(R.id.FournisseurNameTextView);
        ImageView imageView = (ImageView) view.findViewById(R.id.FournisseurImage);

        nameTextView.setText(name);
        imageView.setImageResource(image);

        return view;
    }
}
