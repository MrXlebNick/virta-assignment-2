package com.xlebnick.virtaassignment.data.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xlebnick.virtaassignment.BuildConfig;
import com.xlebnick.virtaassignment.data.net.serializer.DateTypeAdapter;

import java.util.Date;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by XlebNick for VirtaAssignment.
 */

@Module
public class ApiModule {
    private static final String BASE_URL =
            "https://private-anon-093fae5229-virtaapiv4.apiary-proxy.com";

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateTypeAdapter());
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY :
                HttpLoggingInterceptor.Level.NONE);
        return loggingInterceptor;
    }

    @Provides
    @Singleton
    @UsualTimeoutOkHttp
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10, SECONDS);
        builder.readTimeout(10, SECONDS);
        builder.writeTimeout(10, SECONDS);
        builder.addInterceptor(loggingInterceptor);
        return builder.build();
    }

    @Provides
    @Singleton
    @LongTimeoutOkHttp
    OkHttpClient provideLongTimeoutOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60, SECONDS);
        builder.readTimeout(60, SECONDS);
        builder.writeTimeout(60, SECONDS);
        builder.addInterceptor(loggingInterceptor);
        return builder.build();
    }


    @Provides
    @Singleton
    @UsualTimeoutRetrofit
    Retrofit provideRetrofit(@UsualTimeoutOkHttp OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @LongTimeoutRetrofit
    Retrofit provideLongTimeoutRetrofit(@LongTimeoutOkHttp OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    StationsService provideStationsService(
            @LongTimeoutRetrofit Retrofit retrofit) {
        return retrofit.create(StationsService.class);
    }
}
