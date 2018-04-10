package com.xlebnick.virtaassignment.presenter.base;

import android.content.Context;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public abstract class Presenter<V extends MvpView> {
    private Context mContext;
    private V mView;

    public void attachView(Context context, V view) {
        mContext = context;
        mView = view;
        mView.initView();
        onViewAttached();
    }

    public abstract void onViewAttached();

    public void detachView() {
        onViewDetached();
    }

    public abstract void onViewDetached();

    protected Context getContext() {
        return mContext;
    }

    protected V getView() {
        return mView;
    }
}