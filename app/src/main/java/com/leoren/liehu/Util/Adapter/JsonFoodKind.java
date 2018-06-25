package com.leoren.liehu.Util.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.leoren.liehu.User.BaseUserInfo.UserFood.Food;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Author Leoren
 * @Date 2018/6/22 12:27
 * 解析asset里边的json数据
 */
public class JsonFoodKind extends Activity{

    private static final String TAG = "JsonFoodKind";

    public static List<FoodEnergy> initFoodKinds(Context context, int foodKind){

        List<FoodEnergy> list = null;
        StringBuilder sb = new StringBuilder();
        AssetManager am = context.getResources().getAssets();
        InputStream input = null;
        try {
            input = am.open(foodKind+".json" );
            BufferedReader reader = new BufferedReader(new InputStreamReader(input,"UTF-8"));
            String line;
            while ((line = reader.readLine()) != null){
                Log.i(TAG, "initFoodKinds: " + line);
                sb.append(line);
            }
            Gson gson = new Gson();
            list = gson.fromJson(sb.toString(),new TypeToken<List<FoodEnergy>>(){}.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }


        return list;
    }



    //食物能量对照类
    public class FoodEnergy{

        private String name;

        private int value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public FoodEnergy() {
        }

        public FoodEnergy(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }




}
