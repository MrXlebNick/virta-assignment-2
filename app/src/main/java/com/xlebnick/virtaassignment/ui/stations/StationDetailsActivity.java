package com.xlebnick.virtaassignment.ui.stations;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.xlebnick.virtaassignment.R;
import com.xlebnick.virtaassignment.domain.entity.Station;
import com.xlebnick.virtaassignment.ui.base.BaseActivity;

import org.parceler.Parcels;

import butterknife.BindView;

public class StationDetailsActivity extends BaseActivity {

    private static final String EXTRA_STATION = "Station";
    @BindView(R.id.imgBackground)
    ImageView imgBackground;
    @BindView(R.id.imgBack)
    ImageView imgBack;
    @BindView(R.id.txtLocation)
    TextView txtLocation;
    @BindView(R.id.txtCoordinates)
    TextView txtCoordinates;
    @BindView(R.id.txtCity)
    TextView txtCity;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler)
    RecyclerView recycler;

    public static void startActivity(Context context, Station station, TextView txtLocation, TextView txtCoordinates, TextView txtCity) {
        Intent intent = new Intent(context, StationDetailsActivity.class);
        intent.putExtra(EXTRA_STATION, Parcels.wrap(station));
        Pair<View, String> p1 = Pair.create(txtLocation, "location");
        Pair<View, String> p2 = Pair.create(txtCoordinates, "coordinates");
        Pair<View, String> p3 = Pair.create(txtCity, "city");
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, p1, p2, p3);
        context.startActivity(intent, options.toBundle());
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_details);

        Station station = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_STATION));

        supportPostponeEnterTransition();
        txtLocation.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                txtLocation.getViewTreeObserver().removeOnPreDrawListener(this);
                supportStartPostponedEnterTransition();
                return true;
            }
        });

        imgBack.setOnClickListener(view -> onBackPressed());
        txtLocation.setText(station.getName());
        txtCoordinates.setText(String.format("%f/%f",
                station.getLatitude(),
                station.getLongitude()));
        ConnectorsAdapter adapter = new ConnectorsAdapter(this, station.getAllConnectors());
        recycler.setAdapter(adapter);
    }
}
