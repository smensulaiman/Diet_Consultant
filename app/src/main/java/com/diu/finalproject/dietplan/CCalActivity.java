package com.diu.finalproject.dietplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.diu.finalproject.dietplan.DBConnection.MyDatabase;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class CCalActivity extends AppCompatActivity {

    SpinnerDialog spinnerDialog;
    Button srcBtn;
    CheckBox fr,ff,vg;
    private MyDatabase db;
    ArrayList<String> items = new ArrayList<>();
    String tablename = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ccal);

        srcBtn = (Button)findViewById(R.id.search);
        fr = (CheckBox)findViewById(R.id.chkFruite);
        ff = (CheckBox)findViewById(R.id.chkFastfood);
        vg = (CheckBox)findViewById(R.id.chkVeg);

        try{
            db = new MyDatabase(this);
            db.forceDatabaseReload(this);
        }catch (Exception e){
            e.printStackTrace();
        }

        srcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spinnerDialog=new SpinnerDialog(CCalActivity.this,createSampleData(),"Select or Search Food",R.style.DialogAnimations_SmileWindow,"Exit");
                spinnerDialog.setCancellable(true);
                spinnerDialog.setShowKeyboard(false);


                spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
                    @Override
                    public void onClick(String item, int position) {
                        String desc = db.getDescription(item);
                        Intent intent = new Intent(CCalActivity.this,ReadTips.class);
                        intent.putExtra("head","null");
                        intent.putExtra("name",item);
                        intent.putExtra("desc",desc);
                        startActivity(intent);
                        //selectedItems.setText(item + " Position: " + position);
                    }
                });
                spinnerDialog.showSpinerDialog();
            }
        });
    }

    private ArrayList<String> createSampleData() {
        ArrayList<String> itemsample = new ArrayList<>();
        if(fr.isChecked()&&!ff.isChecked()&&!vg.isChecked()){
            Toast.makeText(CCalActivity.this,"if method called",Toast.LENGTH_SHORT).show();
            itemsample = db.getAllFruits();
        }

        return itemsample;
    }
}
