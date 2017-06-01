package com.deppon.zc.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 337453 on 2017-05-08.
 */
@FeignClient(name="hello-find",fallback = HelloFeginClient.FeginClientHystrix.class)
public interface HelloFeginClient {
    @RequestMapping(value="/hello/{str}",method = RequestMethod.GET)
    String saveHello(@RequestParam("str") String str);
    @Component
    static class FeginClientHystrix implements  HelloFeginClient{
        @Override
        public String saveHello(String str) {
            return "你调用的请求出现了异常,你的输入是："+str;
        }
    }
}
