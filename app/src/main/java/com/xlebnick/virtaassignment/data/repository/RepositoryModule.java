package com.xlebnick.virtaassignment.data.repository;

import com.xlebnick.virtaassignment.data.repository.stations.StationsLocalStorage;
import com.xlebnick.virtaassignment.data.repository.stations.StationsRepositoryImpl;
import com.xlebnick.virtaassignment.domain.repository.StationsRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by XlebNick for VirtaAssignment.
 */

@Module
public class RepositoryModule {
    @Provides
    StationsRepository providesStationsRpository(StationsRepositoryImpl stationsRepository) {
        return stationsRepository;
    }

    @Provides
    StationsLocalStorage provideLocalStationsDatabase() {
        return new StationsLocalStorage();
    }
}
