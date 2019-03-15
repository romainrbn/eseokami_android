package com.eseokami.romainrabouan.eseokamijava;

import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class TodayFragment extends Fragment {

    SharedPreferences settings;

    private ArrayList<String> aNames = new ArrayList<>();
    private Context mContext;

    private TextView textView;
    private ImageView image;
    private TextView nameTextView;
    private TextDrawable drawable;
    private TextView reservationStatusTextView;
    private Handler handler;
    private Runnable runnable;
    private TextView cdTextView;
    private TextView numberOfPtsTextView;
    private Button goShocker;
    private DatabaseReference mReference;

    final String PREFS_LOGIN = "PREFS_LOGIN";



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        settings = this.getActivity().getSharedPreferences(PREFS_LOGIN, 0);
        String userName = settings.getString("userFullName", "");
        String usrID = settings.getString("userID", "");
        String sub[] = userName.split(" ", 2);
        String firstName = sub[0];
        mReference = FirebaseDatabase.getInstance().getReference();
        final Boolean hasReserved = settings.getBoolean("aReserveShocker", false);
        reservationStatusTextView = (TextView) getView().findViewById(R.id.reservationStatusTextView);

        numberOfPtsTextView = (TextView) getView().findViewById(R.id.numberOfPointsTextView);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("EEEE dd MMM", Locale.FRANCE);
        String formattedDate = df.format(c.getTime());

        String upperString = formattedDate.substring(0,1).toUpperCase() + formattedDate.substring(1);

      //  String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        textView = (TextView) getView().findViewById(R.id.dateTextView);
        nameTextView = (TextView) getView().findViewById(R.id.nameTextView);
        drawable = TextDrawable.builder().buildRound(firstName.substring(0, 1), R.color.customBlue);
        image = (ImageView) getView().findViewById(R.id.image_view);
        image.setImageDrawable(drawable);

        textView.setText(upperString);
        cdTextView = (TextView) getView().findViewById(R.id.countdownLabel);




        goShocker = (Button) getView().findViewById(R.id.reserverShockerGo);

        if (hasReserved) {
            goShocker.setBackgroundColor(Color.parseColor("#51db39"));
            goShocker.setText("Accéder à la réservation");
            reservationStatusTextView.setTextColor(Color.parseColor("#51db39"));
            reservationStatusTextView.setText("Ta place à bien été réservée !");
        } else {
            goShocker.setOnClickListener(new View.OnClickListener() {

                // En fonction de si la réservation a été faite ou non
                @Override
                public void onClick(View v) {
                    ReservationShockerZoneFragment fragment = new ReservationShockerZoneFragment();
                    android.support.v4.app.FragmentManager manager = getFragmentManager();
                    manager.beginTransaction()
                            .replace(R.id.content_main, fragment, fragment.getTag())
                            .commit();

                }
            });
        }



        createCountdownTimer();


        Log.d("UserName", userName);
        if (userName != null) {
            nameTextView.setText(firstName);

        }



        String pathForDatabase = usrID.replace(".", " ");
        if (pathForDatabase != null) {
            DatabaseReference reference = mReference.child("scores").child(pathForDatabase);
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.hasChild("score")) {
                        Log.d("POINTP", dataSnapshot.child("score").getValue().toString());
                        numberOfPtsTextView.setText(dataSnapshot.child("score").getValue().toString() + " points");
                    } else {
                        // Si pas de données, alors nbPts = 0
                        numberOfPtsTextView.setText("0 point");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else {
            numberOfPtsTextView.setText("Non connecté");

        }





    }

    private void createActivityNames() {
        aNames.add("La cage");
        aNames.add("Trampoline Park");
        aNames.add("Barbecue");
    }

    private void createCountdownTimer() {
        Calendar start_calendar = Calendar.getInstance();
        Calendar end_calendar = Calendar.getInstance();

        long start_millis = start_calendar.getTimeInMillis(); //get the start time in milliseconds
        end_calendar.set(2019, 3, 24, 18, 0, 0); // 10 = November, month start at 0 = January
        long end_millis = end_calendar.getTimeInMillis(); //get the end time in milliseconds
        long total_millis = (end_millis - start_millis); //total time in milliseconds
        new CountDownTimer(total_millis, 1000) {

            public void onTick(long millisUntilFinished) {
                long days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished);
                millisUntilFinished -= TimeUnit.DAYS.toMillis(days);

                long hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished);
                millisUntilFinished -= TimeUnit.HOURS.toMillis(hours);

                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                millisUntilFinished -= TimeUnit.MINUTES.toMillis(minutes);

                long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);
                cdTextView.setText(days + "J " + hours + "H " + minutes + "M " + seconds + "S");
            }

            public void onFinish() {
                cdTextView.setText("done!");
            }
        }.start();
    }





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_today, container, false);
        getActivity().setTitle("Aujourd'hui");







        return rootView;
    }

    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month-1];
    }
}

