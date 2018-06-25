package com.leoren.liehu.Function.Food.MyBody.ThreeMeal;

/**
 * @Author Leoren
 * @Date 2018/6/24 9:45
 * 单个食物选择实体类
 *
 */
public class FoodItemSelect {

    private String foodName;
    private int weight;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public FoodItemSelect(String foodName, int weight) {
        this.foodName = foodName;
        this.weight = weight;
    }

    public FoodItemSelect() {
    }
}
