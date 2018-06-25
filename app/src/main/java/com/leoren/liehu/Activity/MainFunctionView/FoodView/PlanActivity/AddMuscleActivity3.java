package com.leoren.liehu.Activity.MainFunctionView.FoodView.PlanActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.leoren.liehu.Activity.MainFunction;
import com.leoren.liehu.R;

public class AddMuscleActivity3 extends AppCompatActivity implements View.OnClickListener{

    private ImageButton back;
    private TextView finishAdvert;
    private Button completeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_muscle3);

        initViews();


    }

    private void initViews(){
        back = findViewById(R.id.from_add_muscle3_back);
        finishAdvert = findViewById(R.id.muscle_plan_advert);
        completeBtn = findViewById(R.id.muscle_plan_complete);

        back.setOnClickListener(this);
        completeBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.from_add_muscle3_back:
                backActivity();
                break;
            case R.id.muscle_plan_complete:
                musclePlanComplete();
                break;
            default:
                break;
        }
    }

    private void backActivity(){
        Intent intent = new Intent(this, AddMuscleActivity2.class);
        startActivity(intent);
        this.finish();
    }

    private void musclePlanComplete(){
        Intent intent = new Intent(this, MainFunction.class);
        startActivity(intent);

    }

}
