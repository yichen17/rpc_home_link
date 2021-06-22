package com.yichen.facade;

import com.yichen.core.model.foodCookSteps;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/17 11:34
 * @describe 远程  服务 暴露的接口
 */
public interface CookFoodFacade {
    int add(foodCookSteps steps);

    foodCookSteps getFoodCookStepsById(int id);
}
