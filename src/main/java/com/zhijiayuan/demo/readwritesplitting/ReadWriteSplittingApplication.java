package com.zhijiayuan.demo.readwritesplitting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.zhijiayuan.demo.readwritesplitting.mapper")
public class ReadWriteSplittingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadWriteSplittingApplication.class, args);
    }

}
