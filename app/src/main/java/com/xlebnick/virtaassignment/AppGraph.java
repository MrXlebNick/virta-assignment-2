package com.xlebnick.virtaassignment;

import com.xlebnick.virtaassignment.ui.stations.StationsListActivity;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public interface AppGraph {
    void inject(VirtaApplication virtaApplication);

    void inject(StationsListActivity stationsListActivity);
}
