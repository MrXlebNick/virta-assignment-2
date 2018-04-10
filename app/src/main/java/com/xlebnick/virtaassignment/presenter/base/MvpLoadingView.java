package com.xlebnick.virtaassignment.presenter.base;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public interface MvpLoadingView extends MvpView {
    void showLoading();

    void hideLoading();

    void showError(String error);
}
