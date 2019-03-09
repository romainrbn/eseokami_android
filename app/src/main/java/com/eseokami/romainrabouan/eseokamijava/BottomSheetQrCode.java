package com.eseokami.romainrabouan.eseokamijava;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class BottomSheetQrCode extends BottomSheetDialogFragment {

    ImageView image;
    SharedPreferences settings;
    TextView numberOfPoints;
    private DatabaseReference mReference;

    final String PREFS_LOGIN = "PREFS_LOGIN";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_layout, container,false);

        image = v.findViewById(R.id.image);

        settings = this.getActivity().getSharedPreferences(PREFS_LOGIN, 0);
        String usrID = settings.getString("userID", "");

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            // TODO: Mettre texte de l'id, + points...
            BitMatrix bitMatrix = multiFormatWriter.encode(usrID, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            image.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return v;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mReference = FirebaseDatabase.getInstance().getReference();
        numberOfPoints = getView().findViewById(R.id.numberOfPointsQR);
        String userID = settings.getString("userID", "");
        String pathForDatabase = userID.replace(".", " ");

        if (pathForDatabase != null) {
            DatabaseReference reference = mReference.child("scores").child(pathForDatabase);
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.hasChild("score")) {
                        numberOfPoints.setText("Montre-le à un membre ESEOKAMI pour qu'il te rajoute des points ! Pour le moment, tu as " + dataSnapshot.child("score").getValue().toString() + " points");
                    } else {
                        // Si pas de données, alors nbPts = 0
                        numberOfPoints.setText("Montre-le à un membre ESEOKAMI pour qu'il te rajoute des points ! Pour le moment, tu as 0 point.");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    }
}
