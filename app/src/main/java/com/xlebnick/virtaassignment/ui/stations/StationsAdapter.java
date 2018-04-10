package com.xlebnick.virtaassignment.ui.stations;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xlebnick.virtaassignment.R;
import com.xlebnick.virtaassignment.domain.entity.Station;

import java.util.List;

/**
 * Created by XlebNick for VirtaAssignment.
 */

class StationsAdapter extends RecyclerView.Adapter<StationViewHolder> {
    private final Context context;
    private final List<Station> stations;

    public StationsAdapter(Context context, List<Station> stations) {
        this.stations = stations;
        this.context = context;
    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_station, parent, false);
        return new StationViewHolder(context, view);
    }

    @Override
    public void onBindViewHolder(StationViewHolder holder, int position) {
        holder.bind(stations.get(position));
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }
}
