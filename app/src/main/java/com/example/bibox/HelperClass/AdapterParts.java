package com.example.bibox.HelperClass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bibox.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class AdapterParts extends RecyclerView.Adapter<AdapterParts.PartsViewHold> {

    ArrayList<PartsHelper> partsLocations;
    final private ListItemClickListener mOnClickListener;

    public AdapterParts(ArrayList<PartsHelper> partsLocations, ListItemClickListener listener) {
        this.partsLocations = partsLocations;
        mOnClickListener = listener;
    }

    @NonNull
    @Override
    public PartsViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parts_recycler_card, parent, false);
        return new PartsViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartsViewHold holder, int position) {

        PartsHelper partshelper = partsLocations.get(position);
        holder.image.setImageResource(partshelper.getImage());
        holder.title.setText(partshelper.getTitle());


    }

    @Override
    public int getItemCount() {
        return partsLocations.size();
    }


    public interface ListItemClickListener {
        void onPartsListClick(int clickedItemIndex);
    }

    public class PartsViewHold extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView image;
        TextView title;
        RelativeLayout relativeLayout;
        MaterialCardView cardViewParts;


        public PartsViewHold(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            //hooks

            image = itemView.findViewById(R.id.part_image);
            title = itemView.findViewById(R.id.part_title);
            relativeLayout = itemView.findViewById(R.id.background_color);
            cardViewParts = itemView.findViewById(R.id.parts_cardview);

        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onPartsListClick(clickedPosition);
            cardViewParts.toggle();
        }
    }
}
