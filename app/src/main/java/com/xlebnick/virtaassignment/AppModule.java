package com.xlebnick.virtaassignment;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.xlebnick.virtaassignment.data.DataModule;
import com.xlebnick.virtaassignment.presenter.PresenterModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by XlebNick for VirtaAssignment.
 */

@Module(
        includes = {
                DataModule.class,
                PresenterModule.class
        }
)
public class AppModule {
    private Application application;

    public AppModule(@NonNull Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    Context provideAppContext() {
        return application;
    }
}
