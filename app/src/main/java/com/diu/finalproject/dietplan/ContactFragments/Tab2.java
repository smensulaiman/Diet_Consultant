package com.diu.finalproject.dietplan.ContactFragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.diu.finalproject.dietplan.LIstAdapter.UserAdapter;
import com.diu.finalproject.dietplan.R;
import com.diu.finalproject.dietplan.UserModel.User;
import com.diu.finalproject.dietplan.session;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Tab2 extends Fragment {
    private static final String TAG = "Tab2Fragment";
    private List<User> mUser;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2,container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewUser);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));

        mUser = new ArrayList<>();
        DatabaseReference mref = FirebaseDatabase.getInstance().getReference("users");


        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUser.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    User user = snapshot.getValue(User.class);
                    if(!user.getName().equals(session.name)) {
                        mUser.add(user);
                    }
                    //Toast.makeText(getContext(),user.getName(),Toast.LENGTH_SHORT).show();
                }

                UserAdapter adapter = new UserAdapter(getContext(),mUser);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }
}
