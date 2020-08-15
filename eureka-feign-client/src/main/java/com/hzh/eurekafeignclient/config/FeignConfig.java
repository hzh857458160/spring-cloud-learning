package com.hzh.eurekafeignclient.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author HanrAx
 * @className FeignConfig
 * @classDesc TODO
 * @date 2020/02/28
 **/
@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(100, SECONDS.toMillis(1), 500);
    }
}
