package com.xlebnick.virtaassignment.data.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.f2prateek.rx.preferences2.Preference;
import com.f2prateek.rx.preferences2.RxSharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by XlebNick for VirtaAssignment.
 */
@Module
public class PreferenceModule {
    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences("virtaAssignment", MODE_PRIVATE);
    }

    @Provides
    @Singleton
    RxSharedPreferences provideRxSharedPreferences(SharedPreferences preferences) {
        return RxSharedPreferences.create(preferences);
    }

    @Provides
    @Singleton
    @LastUpdateStations
    Preference<Long> providesStationsLastSyncDate(RxSharedPreferences preferences) {
        return preferences.getLong("StationsLastSyncDate");
    }

}
