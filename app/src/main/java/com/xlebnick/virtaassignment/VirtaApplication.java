package com.xlebnick.virtaassignment;

import android.app.Application;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public class VirtaApplication extends Application {

    private static VirtaApplication application;
    private AppGraph appGraph;

    public static AppGraph obtain() {
        return application.appGraph;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
        appGraph = AppComponent.Initializer.init(this);
        appGraph.inject(this);
    }
}
