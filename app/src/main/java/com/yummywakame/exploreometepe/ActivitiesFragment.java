package com.yummywakame.exploreometepe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of Activity venues.
 */
public class ActivitiesFragment extends Fragment {

    public ArrayList<Venue> VenuesDatabase = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ActivitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.venue_list, container, false);

        //Create your ArrayList data
        VenuesDatabase.add(new Venue(getString(R.string.venue_1_title), getString(R.string.venue_1_village),
                R.drawable.venue_1));
        VenuesDatabase.add(new Venue(getString(R.string.venue_0_title), getString(R.string.venue_0_village),
                R.drawable.venue_0));
        VenuesDatabase.add(new Venue(getString(R.string.venue_2_title), getString(R.string.venue_2_village),
                R.drawable.venue_2));
        VenuesDatabase.add(new Venue(getString(R.string.venue_3_title), getString(R.string.venue_3_village),
                R.drawable.venue_3));

        //Create a standard LinearLayout Manager to control how the recycler works
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        //Create an adapter based on the custom class you created
        VenueAdapter venueAdapter = new VenueAdapter(getContext(),VenuesDatabase);

        //Find your Recycler and set your layoutManger and adapter to it
        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(venueAdapter);

        return rootView;
    }
}