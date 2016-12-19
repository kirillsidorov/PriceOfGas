package com.sidorov.pricetogas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {
    FloatingActionButton fab_plus, fab_tel, fab_map;
    Animation FabOpen, FabClose, FabRclockwise, FabRanticlockwise;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = (TextView) findViewById(R.id.telephone);
        TextView textViewAZS = (TextView) findViewById(R.id.name_azs);
        TextView textViewAddress = (TextView) findViewById(R.id.address);

        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_tel = (FloatingActionButton) findViewById(R.id.fab_tel);
        fab_map = (FloatingActionButton) findViewById(R.id.fab_map);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabRclockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        FabRanticlockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);

        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {
                    fab_tel.startAnimation(FabClose);
                    fab_map.startAnimation(FabClose);
                    fab_plus.startAnimation(FabRanticlockwise);
                    fab_tel.setClickable(false);
                    fab_map.setClickable(false);
                    isOpen = false;
                } else {
                    fab_tel.startAnimation(FabOpen);
                    fab_map.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabRclockwise);
                    fab_tel.setClickable(true);
                    fab_map.setClickable(true);
                    isOpen = true;
                }
            }
        });

        Intent intent = getIntent();
        // String fName = intent.getStringExtra("1");
        final String fTelephone = intent.getStringExtra("telephone");
        final String fName = intent.getStringExtra("name");
        final String fAddress = intent.getStringExtra("address");
        Pattern pat = Pattern.compile("[0-9]?");
        final Matcher matcher = pat.matcher(fTelephone);

        if (textView != null) {
            textView.setText(fTelephone);
            textViewAZS.setText(fName);
            textViewAddress.setText(fAddress);
        }

        fab_tel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String telephone = "";
                while (matcher.find()) {
                    telephone += matcher.group();
                }
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + telephone));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });

        fab_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(Main2Activity.this, MapsActivity.class);
                startActivity(map);
            }
        });

    }
}
