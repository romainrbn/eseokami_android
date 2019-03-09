package com.eseokami.romainrabouan.eseokamijava;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class CompteFragment extends Fragment {

    private Button privacyButton;
    SharedPreferences settings;
    final String PREFS_LOGIN = "PREFS_LOGIN";
    private DatabaseReference mReference;
    private TextView textViewPts;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        settings = this.getActivity().getSharedPreferences(PREFS_LOGIN, 0);
        String usrID = settings.getString("userID", "");
        mReference = FirebaseDatabase.getInstance().getReference();
        TextView textViewNom = getView().findViewById(R.id.nameTextVie);

        textViewPts = getView().findViewById(R.id.nbPointsCompte);

        textViewNom.setText("Connecté sous le nom de " + settings.getString("userFullName", ""));
        String pathForDatabase = usrID.replace(".", " ");
        if (pathForDatabase != null) {
            DatabaseReference reference = mReference.child("scores").child(pathForDatabase);
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.hasChild("score")) {
                        textViewPts.setText(dataSnapshot.child("score").getValue().toString() + " points");

                    } else {
                        // Si pas de données, alors nbPts = 0
                       textViewPts.setText("0 point");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


        privacyButton = getView().findViewById(R.id.privacyButton);
        privacyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

    }

    public void openActivity2() {

        Intent intent = new Intent(CompteFragment.this.getActivity(), PrivacyPolicy.class);
        startActivity(intent);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_compte, container, false);
        getActivity().setTitle("Compte et informations");







        return rootView;
    }
}