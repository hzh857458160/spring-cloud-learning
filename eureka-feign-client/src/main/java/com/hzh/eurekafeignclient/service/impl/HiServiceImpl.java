package com.hzh.eurekafeignclient.service.impl;

import com.hzh.eurekafeignclient.service.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HanrAx
 * @className HiService
 * @classDesc TODO
 * @date 2020/02/28
 **/
@Service
public class HiServiceImpl {
    private EurekaClientFeign eurekaClientFeign;

    @Autowired
    public HiServiceImpl(EurekaClientFeign eurekaClientFeign) {
        this.eurekaClientFeign = eurekaClientFeign;
    }

    public String sayHi(String name) {
        return eurekaClientFeign.sayHiFromEurekaClient(name);
    }
}
