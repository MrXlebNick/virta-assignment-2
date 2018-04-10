package com.xlebnick.virtaassignment.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by XlebNick for VirtaAssignment.
 */
public abstract class BaseDialogFragment extends DialogFragment {
    protected final CompositeDisposable disposables = new CompositeDisposable();
    protected boolean isAttached;
    private Unbinder unbinder;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        isAttached = true;
    }

    @Override
    public void onDetach() {
        isAttached = false;
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        disposables.clear();
        unbinder.unbind();
    }
}
