package com.leoren.liehu.Function.Food.MyBody.ThreeMeal;

import com.leoren.liehu.User.BaseUserInfo.UserFood.ChooseFoodItem;

/**
 * @Author Leoren
 * @Date 2018/6/22 12:11
 *
 * 食物类的一些信息  如食物分类的名称
 */
public class FoodContent {


    public static final String[] foodKinds = new String[]{"谷薯芋、杂豆、主食",
            "蛋类、肉类及制品",
            "奶类及制品",
            "蔬果和藻类",
            "坚豆、大豆及制品",
            "饮料",
            "食用油、油脂及制品",
            "调味品",
            "零食、点心、冷饮",
            "其它"};

    /**
     * 食物种类
     * 1       谷薯芋、杂豆、主食
     * 2       蛋类、肉类及制品
     * 3       奶类及制品
     * 4       蔬果和菌藻
     * 5       坚果、大豆及制品
     * 6       饮料
     * 7       食用油、油脂及制品
     * 8       调味品
     * 9       零食、点心、冷饮
     * 10      其它
     */
    public final static int STAPLE_FOOD = 1;
    public final static int EGG_MEAT_FOOD = 2;
    public final static int DAIRY_FOOD = 3;
    public final static int VEGETABLE_FOOD = 4;
    public final static int NUT_FOOD = 5;
    public final static int DRINK_FOOD = 6;
    public final static int COOK_OIL_FOOD = 7;
    public final static int CONDIMENT_FOOD = 8;
    public final static int SNACK_FOOD = 9;
    public final static int OTHER_FOOD = 10;

    public static final ChooseFoodItem[] chooseFoodItems = {new ChooseFoodItem("主食"),
            new ChooseFoodItem("蛋类、肉类及制品"),
            new ChooseFoodItem("奶类及制品"),
            new ChooseFoodItem("蔬果和菌藻"),
            new ChooseFoodItem("坚果、大豆及制品"),
            new ChooseFoodItem("饮料"),
            new ChooseFoodItem("食用油、油脂及制品"),
            new ChooseFoodItem("调味品"),
            new ChooseFoodItem("零食、点心、冷饮"),
            new ChooseFoodItem("其它")};




}
