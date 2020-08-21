package com.hackathon.golo.adaptor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hackathon.golo.R;

import com.hackathon.golo.model.TravelMate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SuggestedAdaptor extends RecyclerView.Adapter<SuggestedAdaptor.ViewHolder> {

    Context mContext;
    ArrayList<TravelMate> travelMateArrayList;

    public SuggestedAdaptor(Context context, ArrayList<TravelMate> explorers) {
        mContext = context;
        travelMateArrayList = explorers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .item_suggest, null, false);
        SuggestedAdaptor.ViewHolder vh = new SuggestedAdaptor.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(travelMateArrayList.get(position).getName());
        holder.tvDesc.setText(travelMateArrayList.get(position).getDescription());

        Glide.with(mContext).load(travelMateArrayList.get(position).getAvatar()).into(holder.ivProfile);

        holder.btFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
                final DatabaseReference mMessagesRef = mRootRef.child("user");
                mMessagesRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Log.d("FJTAG", "Test Call firebaes: " + dataSnapshot.toString());

                        ArrayList<String> userKeyMap = new ArrayList<>();
                        ArrayList<String> userMap = new ArrayList<>();
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            String name = ds.child("name").getValue(String.class);
                            String key = ds.getKey();
                            //Log.d("FJTAG", "name : " + name + "key : "+ key );
                            userMap.add(name);
                            userKeyMap.add(key);
                        }

                        mMessagesRef.child(userKeyMap.get(0)).child("follow").setValue("1");
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return travelMateArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    final class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDesc;
        ImageView ivProfile;
        Button btFollow;

        ViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvDesc = view.findViewById(R.id.tv_desc);
            ivProfile = view.findViewById(R.id.iv_suggest);
            btFollow = view.findViewById(R.id.bt_follow);
        }
    }
}
