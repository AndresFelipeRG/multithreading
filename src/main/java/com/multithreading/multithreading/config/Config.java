package com.multithreading.multithreading.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableAsync
@Slf4j
public class Config {
	
	@Bean(name = "taskExecutor")
	public Executor taskExecutor(){
		log.debug("Creating Async Task executor");
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setThreadNamePrefix("CarThread-");
		executor.initialize();
		return executor;
	}
	

}
