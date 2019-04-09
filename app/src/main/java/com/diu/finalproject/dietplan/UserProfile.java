package com.diu.finalproject.dietplan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.diu.finalproject.dietplan.Videos.VideoActivity;

public class UserProfile extends AppCompatActivity {

    CardView bmi, lg, diettips, services,video,pg,ccal;
    CollapsingToolbarLayout toolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        SharedPreferences sharedPreferences = this.getSharedPreferences("Login", MODE_PRIVATE);
        final String name = sharedPreferences.getString("name", null);

        toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.colapsingtoolbar);
        if (name != null) {

            toolbarLayout.setTitle(name);
        } else {

            toolbarLayout.setTitle("Diet_Consultant_Admin");
        }


        diettips = (CardView) findViewById(R.id.diettips);
        bmi = (CardView) findViewById(R.id.card_ck_bmi);
        lg = (CardView) findViewById(R.id.log_out);
        services = (CardView) findViewById(R.id.services);
        video = (CardView) findViewById(R.id.video);
        pg = (CardView) findViewById(R.id.progress);
        ccal = (CardView) findViewById(R.id.ccal);

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this, DashboardActivity.class));
            }
        });

        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                session.name = null;

                SharedPreferences sp = getSharedPreferences("Login", MODE_PRIVATE);
                SharedPreferences.Editor Ed = sp.edit();
                Ed.putString("name", null);
                Ed.commit();

                startActivity(new Intent(UserProfile.this, LoginActivity.class));
            }
        });

        diettips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this, HealthTips.class));
            }
        });

        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this, Support.class));
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this, VideoActivity.class));
            }
        });

        pg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this, ProgressActivity.class));
            }
        });
        ccal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this, CCalActivity.class));
            }
        });
    }


}
