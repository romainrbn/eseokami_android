package com.eseokami.romainrabouan.eseokamijava;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.service.autofill.ImageTransformation;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;



public class CafetBottomSheet extends BottomSheetDialogFragment {


    ImageView image;
    Button buttonBegin;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cafet_bottom_sheet, container,false);

     //   image = v.findViewById(R.id.rice_icon);
       // int color = Color.parseColor("#f4af41");
       // image.setColorFilter(color);

      //  buttonBegin = v.findViewById(R.id.begin_cafet_btn);
     //   buttonBegin.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
         //       dismiss();
         //   }
       // });

        return v;
    }
}
