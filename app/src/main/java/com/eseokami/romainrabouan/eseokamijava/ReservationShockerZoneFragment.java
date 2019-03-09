package com.eseokami.romainrabouan.eseokamijava;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;


public class ReservationShockerZoneFragment extends Fragment {

    Spinner spinnerHeures;
    Spinner spinnerActivites;
    TextView myTextView;
    String heureSelected;
    String activiteSelected;
    Button reserverButton;
    long nodeCount17Laser;
    long nodeCount18Laser;
    long nodeCount17PaintBall;
    long nodeCount18PaintBall;

    SharedPreferences settings;
    final String PREFS_LOGIN = "PREFS_LOGIN";


    private DatabaseReference mDatabase;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        settings = this.getActivity().getSharedPreferences(PREFS_LOGIN, 0);
        final String userId = settings.getString("userFullName", "");

        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref17 = mDatabase.child("reservations").child("17h45");
        DatabaseReference ref18 = mDatabase.child("reservations").child("18h45");

        final DatabaseReference ref17PaintBall = ref17.child("PaintBall");
        final DatabaseReference ref17Laser = ref17.child("LaserGame");

        final DatabaseReference ref18PaintBall = ref18.child("PaintBall");
        final DatabaseReference ref18Laser = ref18.child("LaserGame");

        // Count
        ref17PaintBall.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                nodeCount17PaintBall = dataSnapshot.getChildrenCount();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ref17Laser.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                nodeCount17Laser = dataSnapshot.getChildrenCount();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ref18PaintBall.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                nodeCount18PaintBall = dataSnapshot.getChildrenCount();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ref18Laser.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                nodeCount18Laser = dataSnapshot.getChildrenCount();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







        spinnerHeures = (Spinner) getView().findViewById(R.id.mySpinner2);
        spinnerActivites = (Spinner) getView().findViewById(R.id.mySpinner1);
        ArrayAdapter<CharSequence> adapterHeures = ArrayAdapter.createFromResource(getContext(), R.array.heures, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterActivites = ArrayAdapter.createFromResource(getContext(), R.array.activites, android.R.layout.simple_spinner_item);

        adapterHeures.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterActivites.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerHeures.setAdapter(adapterHeures);
        spinnerActivites.setAdapter(adapterActivites);
        spinnerHeures.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                heureSelected = parent.getItemAtPosition(position).toString();
              //  Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        spinnerActivites.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                activiteSelected = parent.getItemAtPosition(position).toString();
               // Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        reserverButton = (Button) getView().findViewById(R.id.reserverShockerButton);
        reserverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nodeCount17Laser + nodeCount17PaintBall + nodeCount18Laser + nodeCount18PaintBall < 240) {
                    if (spinnerHeures.getSelectedItemPosition() == 0 && spinnerActivites.getSelectedItemPosition() == 0) {
                        if (nodeCount17PaintBall >= 60) {
                            new AlertDialog.Builder(getContext())
                                    .setTitle("Impossible de réserver")
                                    .setMessage("Toutes les places semblent avoir été réservées pour cette activité. Choisis un autre horaire.")
                                    .setNegativeButton("OK", null)
                                    .show();
                        } else {
                            new AlertDialog.Builder(getContext())
                                    .setTitle("Es-tu sûr ?")
                                    .setMessage("Confirmes-tu ta réservation pour la Shocker Zone ? Ta navette sera à "
                                            + heureSelected + " et ton activité sera " + activiteSelected)
                                    .setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            ref17PaintBall.child("reservations").child(userId).setValue("reservation", new DatabaseReference.CompletionListener() {
                                                @Override
                                                public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                                                    settings.edit().putBoolean("aReserveShocker", true).commit();
                                                }
                                            });
                                        }
                                    })
                                    .setNegativeButton("Annuler", null)
                                    .setIcon(R.drawable.ic_confirmation_number_black_24dp)
                                    .show();
                        }
                    } else if (spinnerHeures.getSelectedItemPosition() == 0 && spinnerActivites.getSelectedItemPosition() == 1) {
                        if (nodeCount17Laser >= 60) {
                            new AlertDialog.Builder(getContext())
                                    .setTitle("Impossible de réserver")
                                    .setMessage("Toutes les places semblent avoir été réservées pour cette activité. Choisis un autre horaire.")
                                    .setNegativeButton("OK", null)
                                    .show();
                        } else {
                            new AlertDialog.Builder(getContext())
                                    .setTitle("Es-tu sûr ?")
                                    .setMessage("Confirmes-tu ta réservation pour la Shocker Zone ? Ta navette sera à "
                                            + heureSelected + " et ton activité sera " + activiteSelected)
                                    .setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            ref17Laser.child("reservations").child(userId).setValue("reservation", new DatabaseReference.CompletionListener() {
                                                @Override
                                                public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                                                    settings.edit().putBoolean("aReserveShocker", true).commit();
                                                    //
                                                }
                                            });
                                        }
                                    })
                                    .setNegativeButton("Annuler", null)
                                    .setIcon(R.drawable.ic_confirmation_number_black_24dp)
                                    .show();
                        }
                    } else if (spinnerHeures.getSelectedItemPosition() == 1 && spinnerActivites.getSelectedItemPosition() == 0) {
                        if (nodeCount18PaintBall >= 60) {
                            new AlertDialog.Builder(getContext())
                                    .setTitle("Impossible de réserver")
                                    .setMessage("Toutes les places semblent avoir été réservées pour cette activité. Choisis un autre horaire.")
                                    .setNegativeButton("OK", null)
                                    .show();
                        } else {
                            new AlertDialog.Builder(getContext())
                                    .setTitle("Es-tu sûr ?")
                                    .setMessage("Confirmes-tu ta réservation pour la Shocker Zone ? Ta navette sera à "
                                            + heureSelected + " et ton activité sera " + activiteSelected)
                                    .setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            ref18PaintBall.child("reservations").child(userId).setValue("reservation", new DatabaseReference.CompletionListener() {
                                                @Override
                                                public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                                                    settings.edit().putBoolean("aReserveShocker", true).commit();
                                                    //
                                                }
                                            });
                                        }
                                    })
                                    .setNegativeButton("Annuler", null)
                                    .setIcon(R.drawable.ic_confirmation_number_black_24dp)
                                    .show();
                        }
                    } else if (spinnerHeures.getSelectedItemPosition() == 1 && spinnerActivites.getSelectedItemPosition() == 1) {
                        if (nodeCount18Laser >= 60) {
                            new AlertDialog.Builder(getContext())
                                    .setTitle("Impossible de réserver")
                                    .setMessage("Toutes les places semblent avoir été réservées pour cette activité. Choisis un autre horaire.")
                                    .setNegativeButton("OK", null)
                                    .show();
                        } else {
                            new AlertDialog.Builder(getContext())
                                    .setTitle("Es-tu sûr ?")
                                    .setMessage("Confirmes-tu ta réservation pour la Shocker Zone ? Ta navette sera à "
                                            + heureSelected + " et ton activité sera " + activiteSelected)
                                    .setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            ref18Laser.child("reservations").child(userId).setValue("reservation", new DatabaseReference.CompletionListener() {
                                                @Override
                                                public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                                                    settings.edit().putBoolean("aReserveShocker", true).commit();
                                                    // Open the reservation fragment
                                                }
                                            });
                                        }
                                    })
                                    .setNegativeButton("Annuler", null)
                                    .setIcon(R.drawable.ic_confirmation_number_black_24dp)
                                    .show();
                        }
                    }

                } else {
                    new AlertDialog.Builder(getContext())
                            .setTitle("Impossible de réserver")
                            .setMessage("Toutes les places semblent avoir été réservées...")
                            .setNegativeButton("OK", null)
                            .show();
                }



            }
        });





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_reservation_shocker_zone, container, false);
        getActivity().setTitle("Billetterie");



        return rootView;
    }




}
