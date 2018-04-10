package com.xlebnick.virtaassignment.data.net;

import com.xlebnick.virtaassignment.domain.entity.Station;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public interface StationsService {

    @GET("/v4/stations")
    Flowable<List<Station>> loadStations(@Query("lastUpdate") Date lastUpdate);
}
