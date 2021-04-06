package com.example.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableEurekaClient
public class ConsumerController {

	@Autowired
	RestTemplate restTemplate;
	
	@LoadBalanced
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	
	@RequestMapping("/hi")
	public String hello(String name) {
		return restTemplate.getForObject("http://eureka-server/hello?name=" + name, String.class);
	}
}
