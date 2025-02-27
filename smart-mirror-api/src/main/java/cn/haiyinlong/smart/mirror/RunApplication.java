package cn.haiyinlong.smart.mirror;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * RunApplication
 * @author HaiYinLong
 * @version 2025/02/27 18:04
**/
@SpringBootApplication
@EnableScheduling
public class RunApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);
    }
}
