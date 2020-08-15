package com.hzh.eurekafeignclient.controller;

import com.hzh.eurekafeignclient.service.impl.HiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HanrAx
 * @className MainController
 * @classDesc TODO
 * @date 2020/02/28
 **/
@RestController
public class MainController {
    private HiServiceImpl hiService;

    @Autowired
    public MainController(HiServiceImpl hiService) {
        this.hiService = hiService;
    }

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "hanrAx", required = false) String name) {
        return hiService.sayHi(name);
    }
}
