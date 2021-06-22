package com.yichen.comsumer.controller;

import com.yichen.core.utils.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/22 17:17
 */
@Controller
public class HelloController {

    private static final Logger logger= LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/getIp")
    @ResponseBody
    public String getFoodCookSteps(HttpServletRequest request){
        logger.info("visit hello controller");
        String ip= IpUtils.getIpAddr(request);
        return "success,ip is "+ip;
    }

}
