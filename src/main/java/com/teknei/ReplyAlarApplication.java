package com.teknei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class ReplyAlarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReplyAlarApplication.class, args);
	}
}