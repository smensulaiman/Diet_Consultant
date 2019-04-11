package com.diu.finalproject.dietplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.diu.finalproject.dietplan.DBConnection.MyDatabase;
import com.diu.finalproject.dietplan.LIstAdapter.ListAdapter;

public class DietTips extends AppCompatActivity {
    ListView list;
    ListAdapter mAdapter;

    MyDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_tips);

        list = findViewById(R.id.list);

        db = new MyDatabase(this);
        db.forceDatabaseReload(this);

        mAdapter = new ListAdapter(this,db.getAllTips());
        list.setAdapter(mAdapter);


    }
}
