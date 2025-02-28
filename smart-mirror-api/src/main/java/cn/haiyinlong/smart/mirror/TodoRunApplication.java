package cn.haiyinlong.smart.mirror;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RunApplication
 *
 * @author HaiYinLong
 * @version 2025/02/27 18:04
 **/
@SpringBootApplication
@MapperScan({"cn.haiyinlong.smart.mirror.infrastructure.dao"})
public class TodoRunApplication {
    public static void main(final String[] args) {
        SpringApplication.run(TodoRunApplication.class, args);
    }
}
