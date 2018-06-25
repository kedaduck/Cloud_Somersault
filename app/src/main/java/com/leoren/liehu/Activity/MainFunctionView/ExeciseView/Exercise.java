package com.leoren.liehu.Activity.MainFunctionView.ExeciseView;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.leoren.liehu.R;

public class Exercise extends AppCompatActivity {

    private TextView exerciseTotalDays;
    private Button startExerciseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        initViews();
    }

    private void initViews(){
        exerciseTotalDays = findViewById(R.id.have_exercise_days_text);
        startExerciseBtn = findViewById(R.id.start_exercise_btn);

        startExerciseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exercise.this, ExerciseActivity.class);
                startActivity(intent);
            }
        });
    }
}
