package com.xlebnick.virtaassignment.data.repository.stations;

import com.xlebnick.virtaassignment.domain.entity.Station;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public class StationsLocalStorage {

    public Flowable<List<Station>> getLocalDatabase() {
        //TODO: implement saving database with Realm
        return Flowable.empty();
    }
}
