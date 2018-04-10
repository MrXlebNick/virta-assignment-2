package com.xlebnick.virtaassignment.ui.stations;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xlebnick.virtaassignment.R;
import com.xlebnick.virtaassignment.domain.entity.Connector;
import com.xlebnick.virtaassignment.domain.entity.Station;
import com.xlebnick.virtaassignment.ui.base.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by XlebNick for VirtaAssignment.
 */

class StationViewHolder extends BaseViewHolder implements View.OnClickListener {

    private final Context context;
    @BindView(R.id.txtLocation)
    TextView txtLocation;
    @BindView(R.id.txtCoordinates)
    TextView txtCoordinates;
    @BindView(R.id.txtCity)
    TextView txtCity;
    @BindView(R.id.viewConnectors)
    LinearLayout viewConnectors;
    private Station station;

    public StationViewHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;
    }

    @SuppressLint({"DefaultLocale", "InflateParams"})
    public void bind(Station station) {
        this.station = station;
        Log.d("***", station.getName());
        itemView.setOnClickListener(this);
        txtLocation.setText(station.getName());
        txtCoordinates.setText(String.format("%f/%f",
                station.getLatitude(),
                station.getLongitude()));
        txtCity.setText(station.getCity());

        viewConnectors.removeAllViews();
        for (int i = 0; i < 4; i++) {
            LinearLayout.LayoutParams layoutParams =
                    new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.weight = 1;
            ViewGroup viewConnectorPreview = (ViewGroup) LayoutInflater.from(context)
                    .inflate(R.layout.item_connector_preview, null);
            viewConnectorPreview.setLayoutParams(layoutParams);

            if (i < station.getAllConnectors().size()) {
                Connector connector = station.getAllConnectors().get(i);
                ((TextView) viewConnectorPreview.findViewById(R.id.txtConnectorValue)).setText(
                        String.format("%.0f", connector.getMaxkw()));
            }
            viewConnectors.addView(viewConnectorPreview);
        }
    }

    @Override
    public void onClick(View v) {
        StationDetailsActivity.startActivity(context, station, txtLocation, txtCoordinates, txtCity);
    }
}
