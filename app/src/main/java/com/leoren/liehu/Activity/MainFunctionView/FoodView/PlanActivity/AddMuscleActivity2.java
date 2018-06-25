package com.leoren.liehu.Activity.MainFunctionView.FoodView.PlanActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.leoren.liehu.R;

public class AddMuscleActivity2 extends AppCompatActivity implements View.OnClickListener{

    private ImageButton back;

    //目标肌肉量显示
    private TextView planMuscleContent;
    //下一步按钮
    private Button nextStepBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_muscle2);

        initViews();


    }

    private void initViews(){
        back = findViewById(R.id.from_add_muscle2_back);
        planMuscleContent = findViewById(R.id.plan_muscle_content);
        nextStepBtn = findViewById(R.id.muscle2_next_btn);

        back.setOnClickListener(this);
        nextStepBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.from_add_muscle2_back:
                backActivity();
                break;
            case R.id.muscle2_next_btn:
                nextStepActivity();
                break;
        }
    }

    //返回原先的界面
    private void backActivity() {
        Intent intent = new Intent(this, AddMuscleActivity1.class);
        startActivity(intent);
        this.finish();
    }

    //下一步界面
    private void nextStepActivity(){
        Intent intent = new Intent(this, AddMuscleActivity3.class);
        startActivity(intent);
    }
}
