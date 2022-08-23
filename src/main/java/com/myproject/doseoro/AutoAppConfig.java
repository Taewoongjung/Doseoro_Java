package com.myproject.doseoro;

import com.myproject.doseoro.infra.mybatis.MyBatisConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.myproject.doseoro.packages"})
public class AutoAppConfig {
}
