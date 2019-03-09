package com.eseokami.romainrabouan.eseokamijava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class JourneeFragment extends ListFragment {

    ListView listView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_journee, container, false);
        getActivity().setTitle("Programme de la journée");
        List<Item> items = new ArrayList<Item>();
        items.add(new ListJournee("L'éveil de RYUJIN", "Petit-déjeuner", "7h30-10h15", "Salle Dirac"));
        items.add(new ListJournee("Le banquet d'inari", "Activités et repas du midi", "12h-12h30", "Salle Dirac"));
        items.add(new ListJournee("La shocker zone", "Activités", "18h-20h", "Angers"));
        items.add(new ListJournee("Les offrandes de Kitsune", "Hotline", "18h-21h", "Angers"));
        items.add(new ListJournee("Le before des yokai", "before", "19h-23h", "Le garden"));
        items.add(new ListJournee("kannagara", "soirée", "21h30-3h", "Domaine de chatillon"));


        JourneeAdapter adapter = new JourneeAdapter(getActivity(), items);
        setListAdapter(adapter);


        return rootView;
    }
}