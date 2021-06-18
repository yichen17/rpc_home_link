package com.yichen.comsumer.controller;

import com.yichen.comsumer.annotation.RpcReference;
import com.yichen.core.model.foodCookSteps;
import com.yichen.facade.CookFoodFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/5/20 14:06
 */
@Controller
public class TestController {

    private static Logger logger= LoggerFactory.getLogger(TestController.class);

    @SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "SpringJavaInjectionPointsAutowiringInspection"})
    @RpcReference(serviceVersion = "1.0", timeout = 3000)
    private CookFoodFacade service;

    @RequestMapping("/add")
    @ResponseBody
    public String add(@RequestBody foodCookSteps steps){
        logger.info("cook food add manage");
        service.add(steps);
        return "add success";
    }
}
