package com.diu.finalproject.dietplan;

import android.content.Intent;
import android.os.Bundle;

import android.app.ListActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.diu.finalproject.dietplan.DBConnection.MyDatabase;
import com.diu.finalproject.dietplan.LIstAdapter.ListAdapter;
import com.diu.finalproject.dietplan.UserModel.TipsModel;

import java.util.ArrayList;
import java.util.List;


public class HealthTips extends ListActivity {
    private static final int NUM_LIST_ITEM = 10;
    private ListAdapter mAdapter;
    private MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);

        db = new MyDatabase(this);
        db.forceDatabaseReload(this);


        mAdapter = new ListAdapter(this,db.getAllTips());
        setListAdapter(mAdapter);
        getListView().setSelection(1);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TextView textView = (TextView)view.findViewById(R.id.text);
                String text = textView.getText().toString();

                Intent intent = new Intent(HealthTips.this,ReadTips.class);
                intent.putExtra("head",text);
                startActivity(intent);

                Toast.makeText(HealthTips.this,String.valueOf(i),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
