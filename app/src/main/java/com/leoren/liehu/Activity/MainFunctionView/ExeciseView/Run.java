package com.leoren.liehu.Activity.MainFunctionView.ExeciseView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.leoren.liehu.Activity.MainFunctionView.ExeciseFragment;
import com.leoren.liehu.R;

import java.util.ArrayList;
import java.util.List;

public class Run extends AppCompatActivity {

    private TextView runTotalTance;
    private Button startRunBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        initViews();
    }

    private void initViews(){
        runTotalTance = findViewById(R.id.run_total_distance_text);
        startRunBtn = findViewById(R.id.start_run_btn);

        startRunBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRunActivity();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }

    private void startRunActivity(){
        //Intent intent = new Intent(Run.this, RunActivity.class);
        //startActivity(intent);
    }

}
