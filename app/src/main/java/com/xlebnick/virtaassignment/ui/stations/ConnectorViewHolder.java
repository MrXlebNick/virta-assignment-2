package com.xlebnick.virtaassignment.ui.stations;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import com.xlebnick.virtaassignment.R;
import com.xlebnick.virtaassignment.domain.entity.Connector;
import com.xlebnick.virtaassignment.ui.base.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by XlebNick for VirtaAssignment.
 */

class ConnectorViewHolder extends BaseViewHolder {

    @BindView(R.id.txtConnectorValue)
    TextView txtConnectorValue;

    public ConnectorViewHolder(View itemView) {
        super(itemView);
    }

    @SuppressLint("DefaultLocale")
    public void bind(Connector connector) {
        txtConnectorValue.setText(String.format("%f", connector.getMaxkw()));
    }
}
