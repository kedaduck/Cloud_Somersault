package com.leoren.liehu.Activity.MainFunctionView.FoodView;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.leoren.liehu.Function.Food.MyBody.ThreeMeal.FoodContent;
import com.leoren.liehu.Function.Food.MyBody.ThreeMeal.FoodItemSelect;
import com.leoren.liehu.Function.Food.MyBody.ThreeMeal.FoodKind;
import com.leoren.liehu.MyView.PopWindow.SelectFoodKindPopWindow;
import com.leoren.liehu.R;
import com.leoren.liehu.Util.Adapter.FoodAdapter.FoodItemAdapter;
import com.leoren.liehu.Util.Adapter.FoodAdapter.FoodKindAdapter;
import com.leoren.liehu.Util.Adapter.JsonFoodKind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectFoodKindActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "SelectFoodKindActivity";

    private ImageButton back;

    private ListView foodKindList;
    private TextView selectFoodCount;
    private Button completeSelectBtn;
    private List<FoodKind> dataList;

    private FoodKindAdapter adapter;

    //打开popupwindow窗口所需
    private View rootLayout;

    private SelectFoodKindPopWindow window;
    //在PopupWindow上显示的ListView
    private RecyclerView foodNameViewList;
    //在popupwindow上的消失按钮
    private ImageButton cancelBtn;
    //在ListView上显示的数据
    private List<FoodItemSelect> foodNameList;
    //打开某个ListView里面显示的食物de能量对应list
    private List<JsonFoodKind.FoodEnergy> foodEnergyList;
    //popuwindow列出food的适配器
    FoodItemAdapter itemadapter ;

    //Integer 代表食物种类   List代表这个种类里边的食物集合
    HashMap<Integer, List<JsonFoodKind.FoodEnergy>> foodMap;
    //当点开一个种类时生成一个临时的list 存放数据
    List<JsonFoodKind.FoodEnergy> selectedFoods;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_select_food_kind);

        initViews();

    }

    private void initViews(){
        back = findViewById(R.id.from_select_food_kind);
        foodKindList = findViewById(R.id.select_food_list);
        selectFoodCount = findViewById(R.id.have_select_food_count);
        completeSelectBtn = findViewById(R.id.select_food_complete_btn);
        initFoodKind();
        adapter = new FoodKindAdapter(this, R.layout.select_food_kind_item, dataList);
        foodKindList.setAdapter(adapter);
        foodKindList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openFoodKindWheel(position);
            }
        });

        rootLayout = findViewById(R.id.select_food_root_layout);

    }

    private void initFoodKind(){
        dataList = new ArrayList<>();
        for(int i = 0 ; i < FoodContent.foodKinds.length; i++ ){
            FoodKind foodKind = new FoodKind(FoodContent.foodKinds[i]);
            dataList.add(foodKind);
        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.from_select_food_kind:
                backActivity();
                break;
            case R.id.select_food_complete_btn:
                completeSelectFood();
                break;
            default:
                break;
        }
    }

    private void backActivity(){

    }

    private void completeSelectFood(){

    }

    /**********带来popuwindow的方法***********************************************************************/

    private void openFoodKindWheel(int code){
        getFoodEnergy(code);

        initPopupWindow();
        showPopupWindow();
    }

    /**
     * 获取该窗口的数据  并填充到显示的listView 里面的dataList
     * @param code  食物种类
     */
    private void getFoodEnergy(int code) {
        //获取食物能量对应关系的集合
        foodEnergyList = new ArrayList<>();
        foodEnergyList = JsonFoodKind.initFoodKinds(this, (code+1));

        if(foodNameList == null){
            foodNameList = new ArrayList<>();
        }
        if(foodNameList != null && foodNameList.size() > 0 ){
            foodNameList.clear();
        }

        for(int i = 0 ; i < foodEnergyList.size() ; i++){
            foodNameList.add(new FoodItemSelect(foodEnergyList.get(i).getName(),0));
        }

        itemadapter = new FoodItemAdapter(foodNameList);

    }

    private void initPopupWindow(){
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenHeight = metrics.heightPixels;

        window = new SelectFoodKindPopWindow(this, R.layout.select_foodenergy_pop_list, ViewGroup.LayoutParams.MATCH_PARENT,(int) (screenHeight * 0.95)) {
            @Override
            protected void initView() {
                View view = getContentView();
                foodNameViewList = view.findViewById(R.id.food_select_list);
                foodNameViewList.setLayoutManager(new GridLayoutManager(getBaseContext(),1));
                foodNameViewList.setAdapter(itemadapter);
                cancelBtn = view.findViewById(R.id.select_food_pop_dismiss);
            }

            @Override
            protected void initEvent() {



                cancelBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        window.getPopupWindow().dismiss();
                    }
                });

            }

            @Override
            protected void initWindow() {
                super.initWindow();
                PopupWindow instance = getPopupWindow();
                instance.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = 1.0f;
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                        getWindow().setAttributes(lp);
                    }
                });
            }
        };
    }

    private void showPopupWindow(){
        PopupWindow win = window.getPopupWindow();
        win.setAnimationStyle(R.style.popanimTranslate);
        window.showAtLocation(rootLayout, Gravity.BOTTOM, 0, 0);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.3f;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(lp);
    }








}
