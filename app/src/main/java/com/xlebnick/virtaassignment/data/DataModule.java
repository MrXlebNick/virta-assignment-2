package com.xlebnick.virtaassignment.data;

import com.xlebnick.virtaassignment.data.net.ApiModule;
import com.xlebnick.virtaassignment.data.preference.PreferenceModule;
import com.xlebnick.virtaassignment.data.repository.RepositoryModule;

import dagger.Module;

/**
 * Created by XlebNick for VirtaAssignment.
 */
@Module(
        includes = {
                ApiModule.class,
                RepositoryModule.class,
                PreferenceModule.class
        }
)
public class DataModule {
}
