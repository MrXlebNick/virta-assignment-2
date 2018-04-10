package com.xlebnick.virtaassignment.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public abstract class BaseFragment extends Fragment {
    protected final CompositeDisposable disposables = new CompositeDisposable();
    private Unbinder unbinder;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        disposables.clear();
        unbinder.unbind();
    }
}
