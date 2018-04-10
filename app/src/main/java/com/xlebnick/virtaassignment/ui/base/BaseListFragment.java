package com.xlebnick.virtaassignment.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.xlebnick.virtaassignment.ui.widget.NetworkProgressView;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public abstract class BaseListFragment extends BaseFragment {
    protected NetworkProgressView networkProgressView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        networkProgressView = new NetworkProgressView(getContext());
        ((ViewGroup) view).addView(networkProgressView);
    }
}
