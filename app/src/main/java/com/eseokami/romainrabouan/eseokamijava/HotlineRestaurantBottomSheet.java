package com.eseokami.romainrabouan.eseokamijava;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;


public class HotlineRestaurantBottomSheet extends BottomSheetDialogFragment {

    private Button buttonRes;
    String restaurantName;
    String restaurantId;
    TextView textViewRes;
    TextView textViewPrenom;
    TextView textViewNom;
    TextView textViewAdresse;
    TextView textViewTel;
    TextView textViewInfos;
    TextView textViewCommande;
    private DatabaseReference mDatabase;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hotline_form_sheet, container,false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // TextViews
        textViewRes = getView().findViewById(R.id.hotlineFillRestaurantName);
        textViewAdresse = getView().findViewById(R.id.hotlineFillAdresse);
        textViewTel = getView().findViewById(R.id.hotlineFillNumero);
        textViewCommande = getView().findViewById(R.id.hotlineFillCommande);
        textViewInfos = getView().findViewById(R.id.hotlineFillInfos);
        textViewNom = getView().findViewById(R.id.hotlineFillName);
        textViewPrenom = getView().findViewById(R.id.hotlineFillFirstName);
        textViewRes.setText(restaurantName);

        buttonRes = getView().findViewById(R.id.hotlineFillConfirmer);

        buttonRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Completer la commande, connexion a la db
                DatabaseReference reference = mDatabase.child("Commandes").child(restaurantId).push();
                reference.child("nom").setValue(textViewNom.getText().toString());
                reference.child("prenom").setValue(textViewPrenom.getText().toString());
                reference.child("adresse").setValue(textViewAdresse.getText().toString());
                reference.child("tel").setValue(textViewTel.getText().toString());
                reference.child("restaurant").setValue(restaurantName);
                // if infos_supp != null, else...
                reference.child("infos_supp").setValue(textViewInfos.getText().toString());
                reference.child("commandes").setValue(textViewCommande.getText().toString(), new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                        if (databaseError != null) {
                            // Show AlertDialog
                        } else {
                            // Validate
                            // SharedPreferences
                        }
                    }
                });
            }
        });


    }
}
