package com.eseokami.romainrabouan.eseokamijava;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class ActivitesBottomSheet extends BottomSheetDialogFragment {
    ImageView image;
    Button buttonBegin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activites_bottom_sheet, container,false);

        image = v.findViewById(R.id.activites_icon);
        int color = Color.parseColor("#f48942");
        image.setColorFilter(color);

        buttonBegin = v.findViewById(R.id.begin_activities_btn);
        buttonBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return v;
    }
}
