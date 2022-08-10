package com.myproject.doseoro;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // basePackages
        // 이렇게 하면 member 폴더만 ComponentScan 의 대상이 된다.
//        basePackages = "hello.core.member",

        // excludeFilters
        // @Configuration 이 붙어있는 것들도 사실상 안에 @Component 가 붙어있어서 포함이 된다. 그래서
        // 이를(기존예제코드) 제거하지 않고 유지시키기 위해서 이 설정을 한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
