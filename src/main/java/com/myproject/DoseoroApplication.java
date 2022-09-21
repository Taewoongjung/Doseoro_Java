package com.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DoseoroApplication {

	public static void main(String[] args) {

		SpringApplication.run(DoseoroApplication.class, args);

	}
}
