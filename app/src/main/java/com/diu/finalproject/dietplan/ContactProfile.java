package com.diu.finalproject.dietplan;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactProfile extends AppCompatActivity {

    private ImageView cons_name;
    TextView cn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_profile);

        String name = getIntent().getStringExtra("name");

        cons_name = (ImageView)findViewById(R.id.call_icon);
        cn = (TextView)findViewById(R.id.cons_name);
        cn.setText(name);

        cons_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialContactPhone("01914667359");
            }
        });
    }

    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
}
