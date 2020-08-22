package com.hackathon.golo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.hackathon.golo.R;

import javax.annotation.Nullable;

public class ConfirmRedeemDialogFragment extends BottomSheetDialogFragment {

    private Button btOk, btCancel;
    ConfirmRedeemDialogInterface confirmDialogInterface;
    public static ConfirmRedeemDialogFragment newInstance() {
        return new ConfirmRedeemDialogFragment();
    }

    public void setConfirmRedeemDialogInterface(ConfirmRedeemDialogInterface confirmDialogInterface) {
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
