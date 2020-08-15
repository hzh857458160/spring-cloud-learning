package com.hzh.eurekaribbonclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author HanrAx
 * @className RibbonService
 * @classDesc TODO
 * @date 2020/02/27
 **/
@Service
public class RibbonService {
    private RestTemplate restTemplate;

    @Autowired
    public RibbonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 加上@HystrixCommand 启用Hystrix熔断器的功能
     * fallbackMethod 为处理回退逻辑的办法，在这里最好只返回静态字符串
     * 这样方便执行快速失败，释放静态资源
     * 如果一定要在fallback中远程调用其他服务，最好在远程调度的服务里，也加上熔断器
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(String name) {
        String url = "http://eureka-client/hi?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }

    public String hiError(String name) {
        return String.format("I'm sorry, %s, error!", name);
    }
}
