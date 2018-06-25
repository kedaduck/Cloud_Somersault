package com.leoren.liehu.Activity.MainFunctionView.ExeciseView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.leoren.liehu.R;

public class Walk extends AppCompatActivity {

    private TextView walkTotalTance;
    private Button startWalkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk);

        initViews();
    }

    private void initViews(){
        walkTotalTance = findViewById(R.id.walk_total_distance_text);
        startWalkBtn = findViewById(R.id.start_walk_btn);

        startWalkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Walk.this, WalkActivity.class);
                startActivity(intent);
            }
        });
    }
}
