package com.leoren.liehu.Util.Adapter.FoodAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.leoren.liehu.Function.Food.MyBody.ThreeMeal.FoodItemSelect;
import com.leoren.liehu.R;

import java.util.List;

/**
 * @Author Leoren
 * @Date 2018/6/24 9:41
 */
public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.ViewHolder> {

    private Context context;

    private List<FoodItemSelect> foodItemSelects;

    static class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout foodSelectItemView;
        TextView foodNameView;
        ImageButton addFoodItemBtn;
        ImageButton delFoodItenBtn;
        TextView foodItemWeight;

        public ViewHolder(View view){
            super(view);
            foodSelectItemView = (LinearLayout) view;
            foodNameView = view.findViewById(R.id.item_food_name_tv);
            addFoodItemBtn = view.findViewById(R.id.add_item_food_btn);
            delFoodItenBtn = view.findViewById(R.id.remove_item_food_btn);
            foodItemWeight = view.findViewById(R.id.item_food_weight_text);
        }

    }

    public FoodItemAdapter(List<FoodItemSelect> foodItemSelects) {
        this.foodItemSelects = foodItemSelects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        if(context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.food_select_item_layout , parent , false);
        final ViewHolder holder = new ViewHolder(view);
        holder.foodSelectItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                final FoodItemSelect item = foodItemSelects.get(position);
                holder.addFoodItemBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int weight = item.getWeight();
                        item.setWeight(weight + 50);
                    }
                });
            }
        });

        return holder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final FoodItemSelect foodItemSelect = foodItemSelects.get(position);
        holder.foodNameView.setText(foodItemSelect.getFoodName());
        holder.foodItemWeight.setText(foodItemSelect.getWeight());
    }

    @Override
    public int getItemCount() {
        return foodItemSelects.size();
    }

}
