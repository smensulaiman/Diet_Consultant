package com.diu.finalproject.dietplan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

public class SplashActivity extends AppCompatActivity {
    private AVLoadingIndicatorView avi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        avi= (AVLoadingIndicatorView) findViewById(R.id.avi);
        avi.setIndicator("BallPulseIndicator");
        avi.show();

        SharedPreferences sp1=this.getSharedPreferences("Login", MODE_PRIVATE);

        final String unm=sp1.getString("name", null);
        if(unm!=null){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    session.name=unm;
                    Intent intent = new Intent(SplashActivity.this,UserProfile.class);
                    startActivity(intent);
                    avi.hide();
                    finish();
                }
            },4000);
        }else {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    session.name=null;
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    avi.hide();
                    finish();
                }
            }, 4000);
        }

    }
}
