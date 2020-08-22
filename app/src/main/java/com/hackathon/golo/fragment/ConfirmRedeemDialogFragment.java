package com.hackathon.golo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.hackathon.golo.R;

import javax.annotation.Nullable;

public class ConfirmRedeemDialogFragment extends BottomSheetDialogFragment {

    private Button btOk, btCancel;
    private Integer sumPoint = 0;
    private TextView tvTitle;

    ConfirmRedeemDialogInterface confirmDialogInterface;
    public static ConfirmRedeemDialogFragment newInstance() {
        return new ConfirmRedeemDialogFragment();
    }

    public void setConfirmRedeemDialogInterface(ConfirmRedeemDialogInterface confirmDialogInterface, Integer sumPoint) {
        this.sumPoint = sumPoint;
        this.confirmDialogInterface = confirmDialogInterface;
    }
    public interface ConfirmRedeemDialogInterface {
        void confirm();
        void cancel();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_confirm_redeem, container,
                false);

        // get the views and attach the listener
        btOk = view.findViewById(R.id.bt_ok);
        btCancel = view.findViewById(R.id.bt_cancel);
        tvTitle = view.findViewById(R.id.tv_title);
        tvTitle.setText("Redeem with "+ sumPoint +" point?");

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialogInterface.confirm();
                dismiss();
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialogInterface.cancel();
                dismiss();
            }
        });

        return view;

    }
}
