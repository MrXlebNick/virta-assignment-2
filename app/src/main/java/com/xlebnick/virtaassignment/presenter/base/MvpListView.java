package com.xlebnick.virtaassignment.presenter.base;

import java.util.List;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public interface MvpListView<T> extends MvpView {
    void showLoading();

    void showError(String error);

    void showEmpty();

    void showContent(List<T> result);
}
