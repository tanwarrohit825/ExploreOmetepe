package com.yummywakame.exploreometepe;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.VenueHolder> {
    private LayoutInflater layoutInflater;
    private ArrayList<Venue> VenuesDatabase;

    //Creates the actual method of performing the recycler
    public VenueAdapter(Context context, ArrayList<Venue> VenuesDatabase) {
        this.layoutInflater = LayoutInflater.from(context);
        this.VenuesDatabase = VenuesDatabase;
    }

    @NonNull
    @Override
    public VenueHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new VenueHolder(view);


    }

    //Binds your Array data to the particular layout views
    @Override
    public void onBindViewHolder(@NonNull VenueHolder holder, int position) {
        final Venue currentVenue = VenuesDatabase.get(position);

        //Assign the values of your ArrayList to the assigned holder views
        holder.venueTitle.setText(currentVenue.getVenueTitle());
        holder.venueTown.setText(currentVenue.getVenueTown());
        holder.venuePhotoId.setImageResource(currentVenue.getVenuePhotoId());

        //On Click Listener that goes to the chosen Venue's ActiviyDetail page
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(v.getContext(),
//                        "You've selected: " + currentVenue.getVenueTitle(),
//                        Toast.LENGTH_SHORT).show();

                Intent venueDetailsIntent = new Intent(v.getContext(), DetailActivity.class);
                // Add the song name and artist name to the intent sent to venueDetailsActivity

                venueDetailsIntent.putExtra("VENUE_TITLE", currentVenue.getVenueTitle());
                venueDetailsIntent.putExtra("VENUE_TOWN", currentVenue.getVenueTown());
                venueDetailsIntent.putExtra("VENUE_IMAGE", currentVenue.getVenuePhotoId());
                v.getContext().startActivity(venueDetailsIntent);
            }
        });
    }

    //Returns your Array size
    @Override
    public int getItemCount() {
        return VenuesDatabase.size();
    }

    //This is a custom holder which is how your data binding occurs, this is where the ids are assigned.
    class VenueHolder extends RecyclerView.ViewHolder {
        private TextView venueTitle;
        private TextView venueTown;
        private ImageView venuePhotoId;

        private VenueHolder(View venueView) {
            super(venueView);
            venueTitle = venueView.findViewById(R.id.venue_title);
            venueTown = venueView.findViewById(R.id.venue_town);
            venuePhotoId = venueView.findViewById(R.id.venue_photo);
        }


    }


}