package com.yichen.cook.food.service;

import com.yichen.cook.food.dao.foodCookStepsMapper;
import com.yichen.core.model.foodCookSteps;
import com.yichen.facade.CookFoodFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/5/20 14:07
 */
@Service
public class TestServiceImpl implements CookFoodFacade {

    @Autowired
    private foodCookStepsMapper dao;

    @Override
    public int add(foodCookSteps steps){
        return dao.insert(steps);
    }

}
