package com.hzh.eurekaclient.controller;

import com.netflix.discovery.DiscoveryManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HanrAx
 * @className MainController
 * @classDesc TODO
 * @date 2020/02/26
 **/
@RestController
public class MainController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
        return String.format("hi %s, I'm from port %s", name, port);

    }

}
