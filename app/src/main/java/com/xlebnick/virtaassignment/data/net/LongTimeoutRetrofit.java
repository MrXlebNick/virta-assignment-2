package com.xlebnick.virtaassignment.data.net;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by XlebNick for VirtaAssignment.
 */


@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface LongTimeoutRetrofit {
}
