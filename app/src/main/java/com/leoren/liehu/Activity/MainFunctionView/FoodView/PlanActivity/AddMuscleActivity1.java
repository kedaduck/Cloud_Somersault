package com.leoren.liehu.Activity.MainFunctionView.FoodView.PlanActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.leoren.liehu.Activity.MainFunction;
import com.leoren.liehu.R;

public class AddMuscleActivity1 extends AppCompatActivity implements View.OnClickListener {

    //返回按钮
    private ImageButton back;

    /**
     * 没有记录时的展示页面
     */
    private LinearLayout notRecordLayout;
    //去记录现在肌肉率的按钮
    private Button goToRecordMuscle;

    /**
     * 有记录时的展示页面
     */
    private LinearLayout recordLayout;
    private TextView nowMuscleContent;
    private Button alterNowMuscle;
    private Button nextStepBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_muscle);

        initViews();

        boolean isHaveRecord = getRecord();
        if (isHaveRecord){
            notRecordLayout.setVisibility(View.GONE);
            recordLayout.setVisibility(View.VISIBLE);
        }else {
            notRecordLayout.setVisibility(View.VISIBLE);
            recordLayout.setVisibility(View.GONE);
        }
    }

    /**
     * 从本地数据库中获取肌肉率这些数据
     * 有的话返回true 显示recordLayout界面
     * 没有的话显示notrecordLayout界面
     */
    private boolean getRecord() {

        return true;
    }

    private void initViews() {
        back = findViewById(R.id.from_add_muscle1_back);

        notRecordLayout = findViewById(R.id.not_have_muscle_record);
        goToRecordMuscle = findViewById(R.id.go_to_record_muscle);

        recordLayout = findViewById(R.id.have_muscle_record_layout);
        nowMuscleContent = findViewById(R.id.now_muscle_content);
        alterNowMuscle = findViewById(R.id.alter_now_muscle_btn);
        nextStepBtn = findViewById(R.id.add_muscle1_next_step);

        back.setOnClickListener(this);
        goToRecordMuscle.setOnClickListener(this);
        alterNowMuscle.setOnClickListener(this);
        nextStepBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.from_add_muscle1_back:
                backActivity();
                break;
            case R.id.go_to_record_muscle:
                recordNowMuscle();
                break;
            case R.id.alter_now_muscle_btn:
                alterNowMuscle();
                break;
            case R.id.add_muscle1_next_step:
                Toast.makeText(this, "下一步", Toast.LENGTH_SHORT).show();
                nextStepActivity();
                break;
        }
    }




    //现在去记录肌肉量
    private void recordNowMuscle() {

    }

    //返回原先界面
    private void backActivity() {
        Intent intent = new Intent(this, MainFunction.class);
        startActivity(intent);
        this.finish();
    }

    //修改当前的肌肉率
    private void alterNowMuscle() {
    }

    //下一步
    private void nextStepActivity(){
        Intent intent = new Intent(this, AddMuscleActivity2.class);
        startActivity(intent);
    }

}

