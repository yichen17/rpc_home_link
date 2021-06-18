//package com.yichen.cook.food.controller;
//
//import com.yichen.core.model.foodCookSteps;
//import com.yichen.cook.food.service.TestServiceImpl;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * @author Qiuxinchao
// * @version 1.0
// * @date 2021/5/20 14:06
// */
//@Controller
//public class TestController {
//
//    private static Logger logger= LoggerFactory.getLogger(TestController.class);
//
//    @Autowired
//    private TestServiceImpl service;
//
//    @RequestMapping("/add")
//    @ResponseBody
//    public String add(@RequestBody foodCookSteps steps){
//        logger.info("cook food add manage");
//        service.add(steps);
//        return "add success";
//    }
//}
