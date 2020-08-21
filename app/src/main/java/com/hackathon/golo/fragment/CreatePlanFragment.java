package com.hackathon.golo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hackathon.golo.R;
import com.hackathon.golo.model.PlanModel;
import com.hackathon.golo.normalactivity.PlanningActivity;

import java.util.HashMap;
import java.util.Map;

public class CreatePlanFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_plan, container, false);
        Button startPlanBtn = rootView.findViewById(R.id.startPlanBtn);
        final TextInputLayout edtTripName = rootView.findViewById(R.id.edt_trip_name);
        Log.i("tag", "create plan");
        final String[] from = {""};
        final String[] to = {""};
        FirebaseApp.initializeApp(rootView.getContext());
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mPlanRef = mRootRef.child("plan/" + getUid());

        SwitchMaterial keep_this_plan_public_switch = rootView.findViewById(R.id.keep_this_plan_public_switch);
        SwitchMaterial publish_as_itineraries_switch = rootView.findViewById(R.id.publish_as_itineraries_switch);

        startPlanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String destinationName = "bangkok";
                Double lat = 13.7432796;
                Double lon = 100.5431358;

                String key = mPlanRef.push().getKey();
                PlanModel planModel = new PlanModel(edtTripName.getEditText().getText().toString(), destinationName, "2020-08-21", "2020-08-22", lat, lon);
                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put("/" + key, planModel);
                mPlanRef.updateChildren(childUpdates);

                Intent intent = new Intent(getActivity(), PlanningActivity.class);
                intent.putExtra("planId", key);
                startActivity(intent);

            }
        });

        MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
        final MaterialDatePicker<Pair<Long, Long>> picker = builder.build();
        final TextInputLayout edtStartEnd = rootView.findViewById(R.id.edt_start_end);
        edtStartEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picker.show(getActivity().getSupportFragmentManager(), picker.toString());
            }
        });
        picker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Pair<Long, Long>>() {
            @Override
            public void onPositiveButtonClick(Pair<Long, Long> selection) {
                android.text.format.DateFormat df = new android.text.format.DateFormat();

                from[0] = df.format("E, MMM dd", selection.first).toString();
                to[0] = df.format("E, MMM dd", selection.second).toString();
                edtStartEnd.getEditText().setText(from[0] + " - " + to[0]);
            }
        });

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FirebaseApp.initializeApp(this.requireContext());
//
//        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
//        final DatabaseReference mPlanRef = mRootRef.child("plan/" + getUid());
//
//        mPlanRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
    }

    private String getUid() {
        return "userid-2";
    }
}
