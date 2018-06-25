package com.leoren.liehu.Activity.MainFunctionView.FoodView.PlanActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leoren.liehu.Activity.MainFunction;
import com.leoren.liehu.R;

public class DeclineFatActivity1 extends AppCompatActivity implements View.OnClickListener{

    private ImageButton back;

    private LinearLayout notRecordLayout;
    private Button goToRecordFatBtn;

    private LinearLayout recordLayout;
    private TextView nowFatContent;
    private Button alterFatBtn;
    private Button nextStepBtn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decline_fat);

        initViews();

        boolean isRecord = getNowFatRecord();
        if(isRecord){
            notRecordLayout.setVisibility(View.GONE);
            recordLayout.setVisibility(View.VISIBLE);
        }else{
            recordLayout.setVisibility(View.GONE);
            recordLayout.setVisibility(View.VISIBLE);
        }
    }

    private boolean getNowFatRecord() {

        return true;
    }

    public void  initViews(){
        back = findViewById(R.id.from_declinefat1_back);

        notRecordLayout = findViewById(R.id.not_have_fat_record_layout);
        goToRecordFatBtn = findViewById(R.id.go_to_record_fat);

        recordLayout = findViewById(R.id.have_fat_record_layout);
        nowFatContent = findViewById(R.id.now_fat_content);
        alterFatBtn = findViewById(R.id.alter_now_fat_btn);
        nextStepBtn = findViewById(R.id.plan_fat1_next_btn);

        back.setOnClickListener(this);
        goToRecordFatBtn.setOnClickListener(this);

        alterFatBtn.setOnClickListener(this);
        nextStepBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.from_declinefat1_back:
                backActivity();
                break;
            case R.id.go_to_record_fat:
                goToRecordFat();
                break;
            case R.id.alter_now_fat_btn:
                alterNowFat();
                break;
            case R.id.plan_fat1_next_btn:
                nextStepActivity();
                break;
            default:
                break;

        }
    }

    /**
     * 返回上一界面
     */
    private void backActivity(){
        Intent intent = new Intent(this , MainFunction.class);
        startActivity(intent);
        this.finish();

    }

    private void goToRecordFat(){

    }

    private void alterNowFat(){

    }
    private void nextStepActivity(){
        Intent intent = new Intent(this, DeclineFatActivity2.class);
        startActivity(intent);
    }
}
