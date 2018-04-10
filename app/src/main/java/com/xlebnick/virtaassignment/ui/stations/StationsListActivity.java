package com.xlebnick.virtaassignment.ui.stations;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.util.Log;

import com.xlebnick.virtaassignment.R;
import com.xlebnick.virtaassignment.VirtaApplication;
import com.xlebnick.virtaassignment.domain.entity.Station;
import com.xlebnick.virtaassignment.presenter.stations.StationsPresenter;
import com.xlebnick.virtaassignment.presenter.stations.StationsView;
import com.xlebnick.virtaassignment.ui.base.BaseActivity;
import com.xlebnick.virtaassignment.ui.widget.NetworkProgressView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class StationsListActivity extends BaseActivity implements StationsView {

    @BindView(R.id.progressView)
    NetworkProgressView progressView;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @Inject
    StationsPresenter presenter;
    private StationsAdapter adapter;
    private List<Station> stations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VirtaApplication.obtain().inject(this);
        setContentView(R.layout.activity_stations_list);
        presenter.attachView(this, this);

        getWindow().setEnterTransition(new Explode());
        getWindow().setExitTransition(new Explode());
    }

    @Override
    public void initView() {
        stations = new ArrayList<>();
        adapter = new StationsAdapter(this, stations);
        recycler.setAdapter(adapter);
        presenter.loadStations();
    }

    @Override
    public void showLoading() {
        progressView.showLoading();
    }

    @Override
    public void showError(String error) {
        progressView.showError(error);
        progressView.setOnRetryClickListener(view -> presenter.loadStations());
    }

    @Override
    public void showEmpty() {
        progressView.showEmpty();
    }

    @Override
    public void showContent(List<Station> result) {
        progressView.showContent();
        stations.clear();
        stations.addAll(result);
        Log.d("***", stations.size() + "");
        adapter.notifyDataSetChanged();

    }
}
