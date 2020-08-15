package com.hzh.eurekafeignclient.service.impl;

import com.hzh.eurekafeignclient.service.EurekaClientFeign;
import org.springframework.stereotype.Component;

/**
 * @author HanrAx
 * @className HiHystrix
 * @classDesc TODO
 * @date 2020/02/28
 **/
@Component
public class HiHystrix implements EurekaClientFeign {
    @Override
    public String sayHiFromEurekaClient(String name) {
        return String.format("Sorry %s, I'm error", name);
    }
}
