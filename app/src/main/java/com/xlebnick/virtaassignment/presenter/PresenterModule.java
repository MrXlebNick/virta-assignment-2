package com.xlebnick.virtaassignment.presenter;

import com.xlebnick.virtaassignment.presenter.stations.StationsPresenter;
import com.xlebnick.virtaassignment.presenter.stations.StationsPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by XlebNick for VirtaAssignment.
 */

@Module
public class PresenterModule {
    @Provides
    StationsPresenter providesStationsPresenter(StationsPresenterImpl stationsPresenter) {
        return stationsPresenter;
    }
}
