package com.personal.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class UtilApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  Spring版本 "+ SpringVersion.getVersion());
        System.out.println("(♥◠‿◠)ﾉﾞ  Boot版本 "+ SpringBootVersion.getVersion());
        System.out.println("(♥◠‿◠)ﾉﾞ  测试类启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
