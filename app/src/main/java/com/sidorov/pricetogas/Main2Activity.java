package com.sidorov.pricetogas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = (TextView) findViewById(R.id.activity_two);


        Intent intent = getIntent();
        String fName = intent.getStringExtra("1");
        if (textView != null) {
            textView.setText(fName);
        }

    }
}
