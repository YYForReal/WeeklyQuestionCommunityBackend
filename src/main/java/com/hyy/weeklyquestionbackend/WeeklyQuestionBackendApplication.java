package com.hyy.weeklyquestionbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hyy.weeklyquestionbackend.mapper")
@MapperScan("com.hyy.weeklyquestionbackend.dao")
public class WeeklyQuestionBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeeklyQuestionBackendApplication.class, args);
    }

}
