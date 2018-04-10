package com.xlebnick.virtaassignment.data.repository.stations;

import com.f2prateek.rx.preferences2.Preference;
import com.xlebnick.virtaassignment.data.net.StationsService;
import com.xlebnick.virtaassignment.data.preference.LastUpdateStations;
import com.xlebnick.virtaassignment.domain.entity.Station;
import com.xlebnick.virtaassignment.domain.repository.StationsRepository;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public class StationsRepositoryImpl implements StationsRepository {


    private final Preference<Long> lastUpdatePreference;
    private final StationsService service;
    private final StationsLocalStorage storage;

    @Inject
    public StationsRepositoryImpl(StationsLocalStorage storage,
                                  StationsService service,
                                  @LastUpdateStations
                                          Preference<Long> lastUpdatePreference) {
        this.lastUpdatePreference = lastUpdatePreference;
        this.service = service;
        this.storage = storage;
    }

    @Override
    public Flowable<List<Station>> loadStations() {
        Date lastUpdate = null;
        if (lastUpdatePreference.get() != 0) {
            lastUpdate = new Date(lastUpdatePreference.get());
        }
        //TODO: insert real lastUpdate when localStorage will be ready
        return service.loadStations(null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
