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

public class DeclineFatActivity3 extends AppCompatActivity implements View.OnClickListener{

    private ImageButton back;

    private TextView planFatAdvert;
    private Button nextStepBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decline_fat3);

        initViews();

    }

    private void initViews() {

        back = findViewById(R.id.from_declinefat3_back);
        planFatAdvert = findViewById(R.id.plan_fat_advert);
        nextStepBtn = findViewById(R.id.plan_fat_complete);

        back.setOnClickListener(this);
        nextStepBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.from_declinefat3_back:
                backActivity();
                break;
            case R.id.plan_fat_complete:
                planFatComplete();
                break;
            default:
                break;
        }
    }

    private void backActivity(){
        Intent intent = new Intent(this, DeclineFatActivity2.class);
        startActivity(intent);
        this.finish();
    }

    private void planFatComplete(){
        Intent intent = new Intent(this, MainFunction.class);
        startActivity(intent);
        this.finish();
    }
}
