package com.eseokami.romainrabouan.eseokamijava;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class CafetFragment extends ListeFragment {

    SharedPreferences prefs = null;
    ListView listView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cafet, container, false);
        getActivity().setTitle("Au menu ce midi");


        prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean previouslyStarted = prefs.getBoolean("dejaLanceeCafet", false);

        List<Item> items = new ArrayList<Item>();
        items.add(new ListCafet("McDonald's", R.drawable.mcdoillustration));
        items.add(new ListCafet("L'Oriflamme", R.drawable.oriflammeillustration));
        items.add(new ListCafet("Sushis", R.drawable.sushisillustration));
        items.add(new ListCafet("Grillades", R.drawable.grilladesillustration));
        items.add(new ListCafet("Pizza", R.drawable.pizzaillustration));

        CafetAdapter adapter = new CafetAdapter(getActivity(), items);
        setListAdapter(adapter);

        if(!previouslyStarted) {
            CafetBottomSheet cafetBottomSheet = new CafetBottomSheet();
            cafetBottomSheet.show(getFragmentManager(), "cafetBottomSheet");

            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean("dejaLanceeCafet", Boolean.TRUE);
            edit.commit();



        }





        return rootView;
    }
}