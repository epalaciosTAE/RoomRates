package com.tae.roomrates.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Eduardo on 20/02/2016.
 * Adapter to display
 * -ImageView x2 (room and rating)
 * -TextView
 * TODO Handle logic to display: room title, roomImage and ratingImage (hide if no rating)
 * TODO implement listeners onLong ,onClick
 */
public class RoomReviewAdapter extends RecyclerView.Adapter<RoomReviewAdapter.ViewHolder> {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
