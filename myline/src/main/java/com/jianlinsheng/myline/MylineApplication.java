package com.jianlinsheng.myline;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MylineApplication {

    public static void main(String[] args) {

        log.info("MylineApplication start");
        SpringApplication.run(MylineApplication.class, args);
    }

}
