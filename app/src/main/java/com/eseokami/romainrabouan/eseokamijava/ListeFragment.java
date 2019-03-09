package com.eseokami.romainrabouan.eseokamijava;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;


public class ListeFragment extends ListFragment {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_liste, container, false);
        getActivity().setTitle("La liste");

        List<Item> items = new ArrayList<Item>();

        items.add(new Header("Bureau", "Le bureau sera ton intelocuteur en cas d'élection. Découvre-les !", null));
        items.add(new ListItem("Marie-Aïnhoa Nicolas", "Présidente"));
        items.add(new ListItem("Nicolas Durat", "Vice-président"));
        items.add(new ListItem("Clara Pasquier", "Vice-présidente"));
        items.add(new ListItem("Alexis Hervé", "Trésorier"));
        items.add(new ListItem("Lucie Siret", "Trésoriere"));
        items.add(new ListItem("Erika Martzlof", "Secrétaire"));

        items.add(new Header("Animation", "Vous pourrez découvrir l'animation tout au long de la semaine, à travers les activités par exemple !", "Leur Kami : Hachiman"));
        items.add(new ListItem("Guillaume Chapela", "Responsable Animation"));
        items.add(new ListItem("Camille Deboue", "Membre Anim"));
        items.add(new ListItem("Tristan Gauville", "Membre Anim"));
        items.add(new ListItem("Clément Puchault", "Membre Anim"));
        items.add(new ListItem("Hugo Garnier", "Membre Anim"));
        items.add(new ListItem("Clément Granseigne", "Membre Anim"));
        items.add(new ListItem("Bryan Ngatchou", "Membre Anim"));

        items.add(new Header("Event", "Cette semaine, c'est eux qui organisent les évènements et les soirées !", "Leur Kami : Susanoo"));
        items.add(new ListItem("Timothée Jouffrieau", "Responsable Event"));
        items.add(new ListItem("Roxanne Laigneau", "Membre Event"));
        items.add(new ListItem("Joseph Guerin", "Membre Event"));
        items.add(new ListItem("Maxime Galliot", "Membre Event"));
        items.add(new ListItem("Dylan Deniau", "Membre Event"));
        items.add(new ListItem("Paul Joseph", "Membre Event"));
        items.add(new ListItem("Benjamin Tortorici", "Membre Event"));
        items.add(new ListItem("Diane Duchaussoy", "Membre Event"));

        items.add(new Header("Communication", "Cette semaine, ils gèrent les réseaux sociaux, l'appli et la communication de la liste !", "Leur kami : Fujin"));
        items.add(new ListItem("Pierre Bertier", "Responsable Communication"));
        items.add(new ListItem("Marylou Alleaume", "Membre Comm."));
        items.add(new ListItem("Amélie Dousteyssier", "Membre Comm."));
        items.add(new ListItem("Romain Rabouan", "Membre Comm."));

        items.add(new Header("Logistique", "Ils organisent la restauration et les transports cette semaine !", "Leur Kami: Inari"));
        items.add(new ListItem("Emmanuel Gelineau", "Responsable Logistique"));
        items.add(new ListItem("Thomas Grébault", "Membre Log."));
        items.add(new ListItem("Paulin Gislard", "Membre Log."));
        items.add(new ListItem("Charles Clément", "Membre Log."));
        items.add(new ListItem("Andy Cousineau", "Membre Log."));

        items.add(new Header("Sponsors", "Ce sont eux qui ont déniché nos entreprises partenaires !", "Leur Kami : Raiden"));
        items.add(new ListItem("Xavier Cordonnier", "Responsable Sponsors"));
        items.add(new ListItem("Margaux Delaunay", "Membre Sponsors"));
        items.add(new ListItem("Paul Lefay", "Membre Sponsors"));
        items.add(new ListItem("Benjamin Dupont", "Membre Sponsors"));

        items.add(new Header("Club", "En cas d'élection, ce sont eux qui gèreront les différents clubs à l'école.", "Leur Kami : Saruta-Hiko"));
        items.add(new ListItem("Théo Cesbron", "Responsable Club"));
        items.add(new ListItem("Louise Gelbart", "Membre Club"));
        items.add(new ListItem("Louis Rampal", "Membre Club"));
        items.add(new ListItem("Soren Guyon", "Membre Club"));

        items.add(new Header("RCIIA", "En cas d'élection, ils gèreront les différentes promotions ainsi que les forums liés à l'ESEO.", "Leur Kami : Uzume"));
        items.add(new ListItem("Chloé Gounot", "Responsable RCIIA"));
        items.add(new ListItem("Julia Body", "Membre RCIIA"));
        items.add(new ListItem("Marie Poirat", "Membre RCIIA"));

        items.add(new Header("Voyage", "Ils organiseront les différents voyages organisés par le BDE.", "Leur Kami : Omoikane"));
        items.add(new ListItem("Justine Petton", "Responsable Voyage"));
        items.add(new ListItem("Léa Bureau", "Membre Voyage"));

        TwoTextArrayAdapter adapter = new TwoTextArrayAdapter(getActivity(), items);
        setListAdapter(adapter);



        return rootView;
    }


}