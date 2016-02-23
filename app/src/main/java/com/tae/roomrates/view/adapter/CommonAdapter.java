package com.tae.roomrates.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Eduardo on 20/02/2016.
 * TODO Handle logic to display: address and rating (hide if no rating)
 * -TextView
 * -ImageView or CircleImageView (colors: red, yellow, green)
 * TODO handle logic to load different layouts depending on the LayoutManager used in RecyclerView.setLayoutManager()
 * -LinearLayout
 * -GridLayout
 * TODO implement listeners onLong ,onClick
 */
public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.ViewHolder> {
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


    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
