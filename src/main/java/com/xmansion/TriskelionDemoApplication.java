package com.xmansion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableAutoConfiguration
@SpringBootApplication
//@ComponentScan( {"com.xmansion","com.xmansion.triskelion.client"})
public class TriskelionDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(TriskelionDemoApplication.class, args);
	}
}
