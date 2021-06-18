package com.yichen.register;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 10:33
 * @describe 注册中心工厂类
 */
public class RegisterFactory {
    private static RegisterService service;
    public static RegisterService getRegisterService(String registerAdd,RegisterType type)throws Exception{
        if(service==null){
            synchronized (RegisterFactory.class){
                if(service==null){
                    switch (type){
                        case ZOOKEEPER:
                            service=new ZookeeperRegisterService(registerAdd);
                            break;
                        case EUREKA:
                            service=new EurekaRegisterService(registerAdd);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return service;
    }

}
