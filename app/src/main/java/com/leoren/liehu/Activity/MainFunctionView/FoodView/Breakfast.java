package com.leoren.liehu.Activity.MainFunctionView.FoodView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.leoren.liehu.Function.Food.MyBody.ThreeMeal.FoodContent;
import com.leoren.liehu.MyView.PopWindow.SelectFoodKindPopWindow;
import com.leoren.liehu.R;

import java.util.List;


public class Breakfast extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Breakfast";

    private Button eatBreakfast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_breakfast);

        eatBreakfast = findViewById(R.id.eat_breakfast);
        eatBreakfast.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.eat_breakfast:
                showFoodKindIntent();
                break;
            default:
                break;
        }
    }

    private void showFoodKindIntent(){
        Intent intent = new Intent(this, SelectFoodKindActivity.class);
        startActivity(intent);

    }

    private void openFoodEnergyWheel(int foodKindCode){
        Toast.makeText(getParent(),foodKindCode,Toast.LENGTH_SHORT).show();
    }

    private void addBreakfastItem(){

    }
}
