package com.yichen.cook.food.service;

import com.yichen.cook.food.annotation.RpcService;
import com.yichen.cook.food.dao.foodCookStepsMapper;
import com.yichen.core.model.foodCookSteps;
import com.yichen.facade.CookFoodFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/5/20 14:07
 */
//@Service
@RpcService(serviceInterface = CookFoodFacade.class)
public class TestServiceImpl implements CookFoodFacade {

    private static final Logger logger=LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    private foodCookStepsMapper dao;

    @Override
    public int add(foodCookSteps steps){
        logger.info("TestServiceImpl 类 add 方法请求入参{}",steps);
        return dao.insert(steps);
    }

    @Override
    public foodCookSteps getFoodCookStepsById(int id) {
        logger.info("TestServiceImpl 类 getFoodCookStepsById 方法请求入参{}",id);
        return dao.selectByPrimaryKey(id);
    }
}
