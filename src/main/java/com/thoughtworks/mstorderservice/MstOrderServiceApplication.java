package com.thoughtworks.mstorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MstOrderServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MstOrderServiceApplication.class, args);
	}
}
