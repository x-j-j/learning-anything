package com.xjjlearning.apache.dubbbo.dubbosampleconsumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboSampleConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboSampleConsumerApplication.class, args);
    }

}
