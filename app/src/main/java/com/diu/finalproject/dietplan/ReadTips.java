package com.diu.finalproject.dietplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.diu.finalproject.dietplan.DBConnection.MyDatabase;

public class ReadTips extends AppCompatActivity {

    TextView header,body;
    private MyDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_tips);

        Intent intent = getIntent();
        String head = intent.getStringExtra("head");
        if(!head.equals("null")) {

            header = (TextView) findViewById(R.id.textViewHead);
            body = (TextView) findViewById(R.id.textView);


            database = new MyDatabase(this);
            database.forceDatabaseReload(this);

            String bodyText = database.getBody(head);

            header.setText(head);
            body.setText(bodyText);
        }else{
            header = (TextView) findViewById(R.id.textViewHead);
            body = (TextView) findViewById(R.id.textView);
            String name = intent.getStringExtra("name");
            String desc = intent.getStringExtra("desc");

            header.setText(name);
            body.setText(desc);
        }


    }
}
