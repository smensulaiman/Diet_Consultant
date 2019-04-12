package com.diu.finalproject.dietplan.ContactFragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.diu.finalproject.dietplan.ContactProfile;
import com.diu.finalproject.dietplan.LIstAdapter.CustomListAdapter;
import com.diu.finalproject.dietplan.R;
import com.diu.finalproject.dietplan.UserModel.Item;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class Tab1 extends Fragment {

    private static final String TAG = "Tab1Fragment";
    private DatabaseReference reference;
    private ListView lv;
    CustomListAdapter adapter;
    ArrayList<Item> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1,container,false);
        lv = (ListView) view.findViewById(R.id.lv);

        final SweetAlertDialog pDialog = new SweetAlertDialog(getContext(), SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        reference = FirebaseDatabase.getInstance().getReference().child("Consultants");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList();
                for(DataSnapshot childSnapshot : dataSnapshot.getChildren()){
                    String key = childSnapshot.getKey();
                    list.add(new Item(dataSnapshot.child(key).child("name").getValue(String.class),dataSnapshot.child(key).child("speciality").getValue(String.class)));
                }

                adapter = new CustomListAdapter(getContext(),list);
                lv.setAdapter(adapter);
                pDialog.dismissWithAnimation();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                View childView = lv.getChildAt(i);
                TextView text = (TextView)childView.findViewById(R.id.partBtn);
                Intent intent = new Intent(getActivity(), ContactProfile.class);
                intent.putExtra("name",text.getText().toString());
                startActivity(intent);
            }
        });

        return view;
    }
}
