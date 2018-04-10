package com.xlebnick.virtaassignment.ui.base;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected final CompositeDisposable disposables = new CompositeDisposable();

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }

    protected void setTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    protected void setSubtitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setSubtitle(title);
        }
    }

    protected void changeFragment(Fragment fragment, @IdRes int containerId) {
        changeFragment(fragment, containerId, false);
    }

    protected void changeFragment(Fragment fragment, @IdRes int containerId, boolean addBackStack) {
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction().replace(containerId, fragment);
        if (addBackStack) {
            transaction.addToBackStack("null");
        }
        transaction.commitAllowingStateLoss();
        getSupportFragmentManager().executePendingTransactions();
    }
}