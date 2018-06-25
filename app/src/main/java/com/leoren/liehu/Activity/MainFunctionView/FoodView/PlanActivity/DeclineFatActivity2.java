package com.leoren.liehu.Activity.MainFunctionView.FoodView.PlanActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.leoren.liehu.R;

public class DeclineFatActivity2 extends AppCompatActivity implements View.OnClickListener{

    private ImageButton back;

    private TextView planFatContent;
    private Button nextStepBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decline_fat2);

        inintViews();
    }

    private void inintViews(){
        back = findViewById(R.id.from_declinefat2_back);

        planFatContent = findViewById(R.id.plan_fat_content);
        nextStepBtn = findViewById(R.id.plan_fat2_next_btn);

        back.setOnClickListener(this);
        nextStepBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.from_declinefat2_back:
                backActivity();
                break;
            case R.id.plan_fat2_next_btn:
                nextStepActivity();
                break;
            default:
                break;
        }

    }

    private void backActivity(){
        Intent intent = new Intent(this, DeclineFatActivity1.class);
        startActivity(intent);
        this.finish();
    }

    private void nextStepActivity(){
        Intent intent = new Intent(this, DeclineFatActivity3.class);
        startActivity(intent);
    }
}
