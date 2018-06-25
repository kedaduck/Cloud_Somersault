package com.leoren.liehu.Activity.MainFunctionView.ExeciseView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.leoren.liehu.R;

public class Bike extends AppCompatActivity {

    private TextView bikeTotalTance;
    private Button bikeStartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike);

        initViews();
    }

    private void initViews(){
        bikeTotalTance = findViewById(R.id.bike_total_distance_text);
        bikeStartBtn = findViewById(R.id.bike_start_btn);

        bikeStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bike.this, BikeActivity.class);
                startActivity(intent);
            }
        });
    }
}
