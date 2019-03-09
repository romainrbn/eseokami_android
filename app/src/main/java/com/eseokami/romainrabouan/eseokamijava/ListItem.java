package com.eseokami.romainrabouan.eseokamijava;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ListItem implements Item {
    public final String str1;
    public final String str2;


    public ListItem(String text1, String text2) {
        this.str1 = text1;
        this.str2 = text2;
    }

    @Override
    public int getViewType() {
        return TwoTextArrayAdapter.RowType.LIST_ITEM.ordinal();
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.my_list_item, null);
            view.setOnClickListener(null);

        } else {
            view = convertView;
        }

        TextView text1 = (TextView) view.findViewById(R.id.list_content2);
        TextView text2 = (TextView) view.findViewById(R.id.fonction_tv);

        ImageView iv = (ImageView) view.findViewById(R.id.profilePicture);
        text1.setText(str1);
        text2.setText(str2);
        iv.setBackgroundResource(R.drawable.void_image);


        return view;
    }
}
