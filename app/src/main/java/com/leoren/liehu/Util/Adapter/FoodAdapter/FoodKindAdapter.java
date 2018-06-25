package com.leoren.liehu.Util.Adapter.FoodAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.leoren.liehu.Function.Food.MyBody.ThreeMeal.FoodKind;
import com.leoren.liehu.R;

import java.util.List;

/**
 * @Author Leoren
 * @Date 2018/6/23 20:29
 * 食物选择适配器
 */
public class FoodKindAdapter extends ArrayAdapter{

    private final int resourceId;

    public FoodKindAdapter (Context context, int textViewResourceId, List<FoodKind> foodKindList){
        super(context,textViewResourceId,foodKindList);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        FoodKind foodKind = (FoodKind) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView foodKindName = view.findViewById(R.id.item_select_food_name);
        Button select_dot = view.findViewById(R.id.food_kind_selected_dot);
        foodKindName.setText(foodKind.getFoodKindName());
        return view;
    }
}
