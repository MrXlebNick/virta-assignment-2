package com.xlebnick.virtaassignment.domain.repository;

import com.xlebnick.virtaassignment.domain.entity.Station;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public interface StationsRepository {
    Flowable<List<Station>> loadStations();
}
