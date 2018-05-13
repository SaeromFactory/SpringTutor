package com.watchers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.watchers.common.DBProperties;


@SpringBootApplication
@PropertySources(value = @PropertySource("classpath:application.properties"))
@EnableConfigurationProperties({DBProperties.class})
public class WatchersServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatchersServerApplication.class, args);
	}
}
