package com.eseokami.romainrabouan.eseokamijava;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.request.transition.Transition;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // true: scanner / false: qrcode
    public static boolean isListe = false;
    String points = "";

    SharedPreferences settings;
    final String PREFS_LOGIN = "PREFS_LOGIN";

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);
        final Activity activity = this;
        ImageButton ib = header.findViewById(R.id.QrButton);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isListe) {
                    // Quelqu'un de la liste
                    IntentIntegrator intentIntegrator = new IntentIntegrator(activity);
                    intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                    intentIntegrator.setPrompt("Scanne le QR Code pour ajouter des points");
                    intentIntegrator.setCameraId(0);
                    intentIntegrator.setBeepEnabled(true);
                    intentIntegrator.setBarcodeImageEnabled(false);
                    intentIntegrator.initiateScan();

                } else {
                    // Un étudiant hors liste
                    System.out.print("salut");
                    Log.d("CLICK", "onClick is called parfaitement");


                    BottomSheetQrCode bottomSheet = new BottomSheetQrCode();
                    bottomSheet.show(getSupportFragmentManager(), "qrBottomSheet");

                }




            }
        });

        displayScreen(R.id.nav_today);
    }





    private void hideItems() {
        settings = this.getSharedPreferences(PREFS_LOGIN, 0);
        final Boolean hasReserved = settings.getBoolean("aReserveShocker", false);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu nav_Menu = navigationView.getMenu();
        if (hasReserved) {
            nav_Menu.findItem(R.id.nav_billetterie).setVisible(false);

            // Reload the data
        } else {
            nav_Menu.findItem(R.id.nav_billetterie).setVisible(true);
            // Reload the data
        }


    }


    @Override
    protected void onResume() {
        super.onResume();

        hideItems();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(this, "Aucune donnée trouvée dans le code", Toast.LENGTH_LONG).show();


            } else {
             //   Toast.makeText(this, intentResult.getContents(), Toast.LENGTH_LONG).show();
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Ajouter des points");
                alertDialog.setMessage("Ajoute des points à " + intentResult.getContents()); // Changer pour obtenir seulement le nom

                final EditText input = new EditText(MainActivity.this);

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                alertDialog.setView(input);

                alertDialog.setPositiveButton("Terminé", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        points = input.getText().toString();

                    }
                });

                alertDialog.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });


                alertDialog.show();



            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    public void displayScreen(int id) {
        Fragment fragment = null;
        switch(id){
            case R.id.nav_today:
                fragment = new TodayFragment();
                break;
            case R.id.nav_activites:
                fragment = new ActivitesFragment();
                break;
            case R.id.nav_cafeteria:
                fragment = new CafetFragment();
                break;
            case R.id.nav_idees:
                fragment = new IdeesFragment();
                break;
            case R.id.nav_hotline:
                fragment = new HotlineFragment();
                break;
            case R.id.nav_journee:
                fragment = new JourneeFragment();
                break;
            case R.id.nav_billetterie:
                fragment = new ReservationShockerZoneFragment();
                break;
            case R.id.nav_sponsors:
                fragment = new SponsorsFragment();
                break;
            case R.id.nav_deconnexion:
                // A revoir
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Déconnexion");
                alertDialog.setIcon(R.drawable.ic_close_black_24dp);
                alertDialog.setMessage("Es-tu sûr de vouloir te déconnecter ?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Oui, je suis sûr",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();
                                // Show login activity
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                // Delete token
                                startActivity(intent);


                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Annuler",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }
                );
                alertDialog.show();
                break;
            case R.id.nav_compte:
                fragment = new CompteFragment();
                break;
            case R.id.nav_videos:
                fragment = new VideosFragment();
                break;
            case R.id.nav_liste:
                fragment = new ListeFragment();
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        displayScreen(id);


        return true;
    }
}
