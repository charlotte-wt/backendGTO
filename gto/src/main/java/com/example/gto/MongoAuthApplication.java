package com.example.gto;

import com.example.gto.config.MongoConfig;
import com.example.gto.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ SecurityConfig.class, MongoConfig.class })
//@EnableMongoRepositories("com.example.gto")
public class MongoAuthApplication {

    public static void main(String... args) {
        SpringApplication.run(MongoAuthApplication.class, args);
    }

}
