package com.xlebnick.virtaassignment.presenter.stations;

import com.f2prateek.rx.preferences2.Preference;
import com.xlebnick.virtaassignment.data.preference.LastUpdateStations;
import com.xlebnick.virtaassignment.domain.repository.StationsRepository;
import com.xlebnick.virtaassignment.presenter.exception.ErrorMessageFactory;

import java.util.Date;

import javax.inject.Inject;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public class StationsPresenterImpl extends StationsPresenter {

    private final StationsRepository stationsRepository;
    private final Preference<Long> lastUpdatePreference;

    @Inject
    public StationsPresenterImpl(StationsRepository stationsRepository,
                                 @LastUpdateStations Preference<Long> lastUpdatePreference) {
        this.stationsRepository = stationsRepository;
        this.lastUpdatePreference = lastUpdatePreference;
    }

    @Override
    public void loadStations() {
        getView().showLoading();
        stationsRepository.loadStations().subscribe(stations -> {

                    lastUpdatePreference.set(new Date().getTime());
                    if (stations.size() > 0) {
                        getView().showContent(stations);
                    } else {
                        getView().showEmpty();
                    }
                },
                throwable -> getView().showError(ErrorMessageFactory.getErrorMessage(getContext(),
                        throwable)));
    }

    @Override
    public void onViewAttached() {

    }

    @Override
    public void onViewDetached() {

    }
}
