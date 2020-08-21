package com.hackathon.golo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.hackathon.golo.R;

import javax.annotation.Nullable;

public class PaymentDialogFragment extends BottomSheetDialogFragment {

    private Button btOk, btCancel;
    PaymentDialogInterface paymentDialogInterface;
    public static PaymentDialogFragment newInstance() {
        return new PaymentDialogFragment();
    }

    public void setPaymentDialogInterface(PaymentDialogInterface paymentDialogInterface) {
        this.paymentDialogInterface = paymentDialogInterface;
    }
    public interface PaymentDialogInterface {
        void payment();
        void cancel();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_bottom_payment, container,
                false);

        // get the views and attach the listener
        btOk = view.findViewById(R.id.bt_ok);
        btCancel = view.findViewById(R.id.bt_cancel);

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paymentDialogInterface.payment();
                dismiss();
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paymentDialogInterface.cancel();
                dismiss();
            }
        });

        return view;

    }
}
