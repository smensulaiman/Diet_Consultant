package com.diu.finalproject.dietplan.FoodFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.diu.finalproject.dietplan.DBConnection.MyDatabase;
import com.diu.finalproject.dietplan.R;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class Vegeterian extends Fragment {

    MyDatabase db;

    private TextView min,max;
    public Vegeterian() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_vegeterian, container, false);
        DiscreteSeekBar seekBar1 = (DiscreteSeekBar)view.findViewById(R.id.discrete1);
        DiscreteSeekBar seekBar2 = (DiscreteSeekBar)view.findViewById(R.id.discrete2);

        db = new MyDatabase(getContext());
        db.forceDatabaseReload(getContext());

        min = view.findViewById(R.id.min);
        max = view.findViewById(R.id.max);


        RecyclerView recyclerView = view.findViewById(R.id.RecyclerView);
        RecycleAdapter adapter = new RecycleAdapter(getContext(),db.getFood("select name from cffr"));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        seekBar1.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                //Toast.makeText(getContext(),value,Toast.LENGTH_SHORT).show();
                min.setText(String.valueOf(value));
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });

        seekBar2.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                max.setText(String.valueOf(value));
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });

        return view;
    }

}
