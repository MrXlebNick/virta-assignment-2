package com.xlebnick.virtaassignment.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.xlebnick.virtaassignment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public class NetworkProgressView extends FrameLayout {
    @BindView(R.id.view_progress)
    View viewProgress;
    @BindView(R.id.view_error)
    View viewError;
    @BindView(R.id.view_empty)
    View viewEmpty;
    @BindView(R.id.txt_error)
    TextView txtError;
    @BindView(R.id.gif_image_view)
    GifImageView gifImageView;
    private OnClickListener mOnRetryClickListener;

    public NetworkProgressView(Context context) {
        super(context);
        inflate(getContext(), R.layout.layout_network_progress, this);
        setLayoutParams(generateDefaultLayoutParams());
        ButterKnife.bind(this);
        setVisibility(GONE);
        initialize();
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    private void initialize() {
        GifDrawable gifDrawable = (GifDrawable) gifImageView.getDrawable();
        gifDrawable.setLoopCount(0);
    }

    public NetworkProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(getContext(), R.layout.layout_network_progress, this);
        setLayoutParams(generateDefaultLayoutParams());
        ButterKnife.bind(this);
        setVisibility(GONE);
        initialize();
    }

    public NetworkProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(getContext(), R.layout.layout_network_progress, this);
        setLayoutParams(generateDefaultLayoutParams());
        ButterKnife.bind(this);
        setVisibility(GONE);
        initialize();
    }

    @OnClick(R.id.txt_retry)
    void onRetryClicked(View view) {
        if (mOnRetryClickListener != null) {
            mOnRetryClickListener.onClick(view);
        }
    }

    public void showLoading() {
        setVisibility(VISIBLE);
        viewError.setVisibility(GONE);
        viewProgress.setVisibility(VISIBLE);
    }

    public void showError() {
        showError(null);
    }

    public void showError(String error) {
        setVisibility(VISIBLE);
        txtError.setText(TextUtils.isEmpty(error) ?
                getContext().getString(R.string.internet_connection_problem) :
                error);
        viewProgress.setVisibility(GONE);
        viewError.setVisibility(VISIBLE);
    }

    public void showEmpty() {
        setVisibility(VISIBLE);
        viewProgress.setVisibility(GONE);
        viewError.setVisibility(GONE);
        viewEmpty.setVisibility(VISIBLE);
    }

    public void showContent() {
        viewProgress.setVisibility(GONE);
        viewError.setVisibility(GONE);
        viewEmpty.setVisibility(GONE);
        setVisibility(GONE);
    }

    public void setOnRetryClickListener(OnClickListener onRetryClickListener) {
        mOnRetryClickListener = onRetryClickListener;
    }
}
