package com.deppon.zc.controller;

import com.deppon.zc.service.HelloFeginClient;
import com.deppon.zc.service.TestHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 337453 on 2017-05-08.
 */
@RestController
public class FeginController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private HelloFeginClient helloFeginClient;
    @Autowired
    private TestHello testHello;
    @RequestMapping(value="/fegin/{str}",method= RequestMethod.GET)
    public String saveHello(@PathVariable String str){

        return helloFeginClient.saveHello(str);
    }

    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String saveHello(){
        return testHello.getStr();
    }

    @RequestMapping(value="/fegin/info",method= RequestMethod.GET)
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }

}
