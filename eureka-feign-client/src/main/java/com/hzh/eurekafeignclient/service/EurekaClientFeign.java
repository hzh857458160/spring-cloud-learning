package com.hzh.eurekafeignclient.service;

import com.hzh.eurekafeignclient.config.FeignConfig;
import com.hzh.eurekafeignclient.service.impl.HiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client", configuration = FeignConfig.class,
        fallback = HiHystrix.class)
public interface EurekaClientFeign {
    @GetMapping("/hi")
    String sayHiFromEurekaClient(@RequestParam(value = "name") String name);
}
