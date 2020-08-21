package com.hackathon.golo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.type.DateTime;
import com.hackathon.golo.R;
import com.hackathon.golo.model.PlanModel;
import com.hackathon.golo.model.PlaningModel;
import com.hackathon.golo.model.UserModel;
import com.hackathon.golo.normalactivity.PlanningActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

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
        final String[] fromFormat = {""};
        final String[] toFormat = {""};
        FirebaseApp.initializeApp(rootView.getContext());
        final DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mPlanRef = mRootRef.child("plan/" + getUid());
        final SwitchMaterial keepThisPlanPublicSwitch = rootView.findViewById(R.id.keep_this_plan_public_switch);
        final SwitchMaterial publishAsItinerariesSwitch = rootView.findViewById(R.id.publish_as_itineraries_switch);

        startPlanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String destinationName = "bangkok";
                Double lat = 13.7432796;
                Double lon = 100.5431358;
                final boolean[] updated = {false};

                String key = mPlanRef.push().getKey();
                List<String> dates = getDates(fromFormat[0], toFormat[0]);
                Map<String, PlaningModel> dateRange = new HashMap<>();
                for(String date:dates)
                    dateRange.put(date, new PlaningModel());
                PlanModel planModel = new PlanModel(edtTripName.getEditText().getText().toString(), destinationName, from[0], to[0], lat, lon, dateRange);
                Log.d(TAG, "planModel: " + planModel.toString());

                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put("/" + key, planModel);
                mPlanRef.updateChildren(childUpdates);

                final DatabaseReference mUserRef = mRootRef.child("user/" + getUid());
                mUserRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        UserModel userModel = dataSnapshot.getValue(UserModel.class);
                        if (!updated[0]) {
                            if (userModel != null) {
                                Integer point = userModel.getPoint() == null ? 0 : userModel.getPoint();

                                if (keepThisPlanPublicSwitch.isChecked()) {
                                    point += 10;
                                }
                                if (publishAsItinerariesSwitch.isChecked()) {
                                    point += 20;
                                }
                                Map<String, Object> childUpdates = new HashMap<>();
                                childUpdates.put("/point", point);
                                mUserRef.updateChildren(childUpdates);
                                updated[0] = true;
                            }
                        }

                        Log.d(TAG, "Value is: " + dataSnapshot.toString());
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
//                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

                Intent intent = new Intent(getActivity(), PlanningActivity.class);
                intent.putExtra("planId", key);
                startActivity(intent);

            }
        });

        MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
        final MaterialDatePicker<Pair<Long, Long>> picker = builder.build();
        final TextInputLayout edtStartEnd = rootView.findViewById(R.id.edt_start_end);
        edtStartEnd.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    picker.show(getActivity().getSupportFragmentManager(), picker.toString());
                } else {

                }
            }
        });
        edtStartEnd.getEditText().setOnClickListener(new View.OnClickListener() {
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
                fromFormat[0] = df.format("yyyy-MM-dd", selection.first).toString();
                toFormat[0] = df.format("yyyy-MM-dd", selection.second).toString();
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

    private static List<String> getDates(String dateString1, String dateString2)
    {
        ArrayList<String> dates = new ArrayList<>();
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = null;
        Date date2 = null;

        try {
            date1 = df1 .parse(dateString1);
            date2 = df1 .parse(dateString2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);


        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        while(!cal1.after(cal2))
        {
            dates.add(df1.format(cal1.getTime()));
            cal1.add(Calendar.DATE, 1);
        }
        return dates;
    }
}
