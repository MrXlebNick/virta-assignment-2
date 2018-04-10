package com.xlebnick.virtaassignment;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

@Component(
        modules = {
                AppModule.class
        }
)
@Singleton
public interface AppComponent extends AppGraph {

    final class Initializer {
        private Initializer() {
        }

        static AppComponent init(Application app) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .build();
        }
    }
}
