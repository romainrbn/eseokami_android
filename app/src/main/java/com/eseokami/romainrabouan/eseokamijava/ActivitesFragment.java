package com.eseokami.romainrabouan.eseokamijava;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ActivitesFragment extends ListFragment {

    SharedPreferences prefs = null;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activites, container, false);
        getActivity().setTitle("Activités");

        List<Item> items = new ArrayList<Item>();

        items.add(new HeaderActivites("À la pause"));
        items.add(new ItemActivites("Stand Photo", R.drawable.activite_photos, ""));
        items.add(new ItemActivites("Stand Jeux Vidéo : PS4, Xbox One", R.drawable.activite_jvideos, ""));
        items.add(new ItemActivites("Le Poing de Kintaro", R.drawable.activite_kintaro, "Frapperas-tu aussi fort que Kintaro ?"));
        items.add(new ItemActivites("Les Palets de Fujin", R.drawable.activite_palets, "Qui sème le vent, récolte la tempête..."));

        items.add(new HeaderActivites("Ce midi"));
        items.add(new ItemActivites("Les désirs d'Uzume", R.drawable.activite_uzume, "Les rires éclatent mieux lorsque la nourriture est bonne..."));
        items.add(new ItemActivites("L'assault d'Hachiman", R.drawable.activite_hachiman, "Réveille le Ninja qui est en toi !"));
        items.add(new ItemActivites("La Route d'Izanami", R.drawable.activite_mirror, "Courir ou mourir, tel est le dilemme d'Izamani !"));
        items.add(new ItemActivites("Le Duel de Raijin", R.drawable.activite_kintaro, "Coup de tonerre sur le ring, qui en ressortira vainqueur ?"));
        items.add(new ItemActivites("L'arbre de Saruta", R.drawable.activite_saruta, "Même le singe tombe de l'arbre..."));
        items.add(new ItemActivites("Voyage vers Tsukuyomi", R.drawable.activite_ejector, "Boucle ta ceinture, décollage imminent vers Tsukuyomi !"));
        items.add(new ItemActivites("Le combat des Kamis", R.drawable.activite_sumo, "Kami rentre dans le cercle mais ne met pas le genou à terre !"));


        items.add(new HeaderActivites("Le Before"));
        items.add(new ItemActivites("La Colère de Susanoo", R.drawable.activite_susanoo, "Susanoo ne semble pas d'humeur aujourd'hui, les cyclones sont de sortie..."));
        items.add(new ItemActivites("Les verres de Shojo", R.drawable.activite_mojito_pong, "Fais preuve de précision si tu ne veux pas trinquer aver Shojo !"));
        items.add(new ItemActivites("Shinigami 21", R.drawable.activite_shinigami, "Shinigami ou 21, à toi de voir !"));
        items.add(new ItemActivites("Les ruses d'Inari", R.drawable.activite_inari, "Sauras-tu déjouer les ruses d'Inari ?"));

        items.add(new HeaderActivites("En soirée"));
        items.add(new ItemActivites("La quête d'Ishikawa", R.drawable.activite_ishikawa, "Ma question préférée, qu'est ce que je vais faire de tout cet oseille ?"));
        items.add(new ItemActivites("Le tapis d'Omukade", R.drawable.activite_twister, "Cours de Stretching Japonais géant"));
        items.add(new ItemActivites("Les tonneaux d'Haradashi", R.drawable.activite_beer_pong_geant, "Des trous plus grands pour les moins doués..."));
        items.add(new ItemActivites("Les langues de Kasa-Obake", R.drawable.activite_elastique, "Tire la langue et cours !"));



        ActivitesAdapter adapter = new ActivitesAdapter(getActivity(), items);
        setListAdapter(adapter);


        prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean previouslyStarted = prefs.getBoolean("dejaLanceeActivite", false);

        if(!previouslyStarted) {
            ActivitesBottomSheet activitesBottomSheet = new ActivitesBottomSheet();
            activitesBottomSheet.show(getFragmentManager(), "activitesBottomSheet");

            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean("dejaLanceeActivite", Boolean.TRUE);
            edit.commit();



        }
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();



    }
}