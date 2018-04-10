package com.xlebnick.virtaassignment.ui.stations;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xlebnick.virtaassignment.R;
import com.xlebnick.virtaassignment.domain.entity.Connector;

import java.util.List;

/**
 * Created by XlebNick for VirtaAssignment.
 */

class ConnectorsAdapter extends RecyclerView.Adapter<ConnectorViewHolder> {

    private final Context context;
    private final List<Connector> connectors;

    public ConnectorsAdapter(Context context, List<Connector> connectors) {
        this.context = context;
        this.connectors = connectors;

    }

    @Override
    public ConnectorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_connector, parent, false);
        return new ConnectorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ConnectorViewHolder holder, int position) {
        holder.bind(connectors.get(position));
    }

    @Override
    public int getItemCount() {
        return connectors.size();
    }
}
