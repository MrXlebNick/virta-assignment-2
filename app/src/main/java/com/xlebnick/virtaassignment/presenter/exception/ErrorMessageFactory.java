package com.xlebnick.virtaassignment.presenter.exception;

import android.content.Context;

import com.google.gson.Gson;
import com.xlebnick.virtaassignment.R;
import com.xlebnick.virtaassignment.data.model.HttpError;

import java.io.IOException;

import retrofit2.HttpException;

/**
 * Created by XlebNick for VirtaAssignment.
 */
public class ErrorMessageFactory {

    public static String getErrorMessage(Context context, Throwable throwable) {
        throwable.printStackTrace();
        if (throwable instanceof IOException) {
            return context.getString(R.string.internet_connection_problem);
        }
        if (throwable instanceof HttpException) {
            try {
                HttpError error = new Gson().fromJson(((HttpException) throwable).response()
                                .errorBody()
                                .string(),
                        HttpError.class);
                return error.getMessage();
            } catch (Exception e) {
                return context.getString(R.string.something_wrong);
            }
        }
        return context.getString(R.string.unknown_error);
    }
}
