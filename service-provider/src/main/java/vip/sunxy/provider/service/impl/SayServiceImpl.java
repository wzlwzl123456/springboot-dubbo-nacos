package vip.sunxy.provider.service.impl;

import vip.sunxy.dubbo.serivce.SayService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Aiguo
 */
@DubboService
public class SayServiceImpl implements SayService {

    @Value("${dubbo.application.name}")
    private String serviceName;
    @Override
    public String sayHelloByName(String name) {
        return serviceName + " say:hello,"+name;
    }
}
