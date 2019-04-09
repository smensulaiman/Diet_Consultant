package com.diu.finalproject.dietplan.ContactFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diu.finalproject.dietplan.R;
import com.diu.finalproject.dietplan.UserModel.User;
import com.diu.finalproject.dietplan.session;

import java.util.List;


public class Tab3 extends Fragment {
    private static final String TAG = "Tab3Fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab3,container,false);

        TextView t = (TextView)view.findViewById(R.id.name);
        t.setText(session.name);
        return view;
    }
}
