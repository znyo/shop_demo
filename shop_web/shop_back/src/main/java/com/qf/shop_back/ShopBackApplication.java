package com.qf.shop_back;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication(scanBasePackages = "com.qf")
public class ShopBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopBackApplication.class, args);
    }

}
