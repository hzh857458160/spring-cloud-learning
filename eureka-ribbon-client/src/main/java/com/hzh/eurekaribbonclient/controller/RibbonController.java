package com.hzh.eurekaribbonclient.controller;

import com.hzh.eurekaribbonclient.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HanrAx
 * @className RibbonController
 * @classDesc TODO
 * @date 2020/02/27
 **/
@RestController
public class RibbonController {
    private RibbonService ribbonService;
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    public RibbonController(RibbonService ribbonService, LoadBalancerClient loadBalancerClient) {
        this.ribbonService = ribbonService;
        this.loadBalancerClient = loadBalancerClient;
    }

    @GetMapping("/hi")
    public String hi(@RequestParam(required = false, defaultValue = "hanrAx") String name) {
        return ribbonService.hi(name);
    }

    @GetMapping("/testRibbon")
    public String testRibbon() {
        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
        return instance.getHost() + ":" + instance.getPort();
    }
}
