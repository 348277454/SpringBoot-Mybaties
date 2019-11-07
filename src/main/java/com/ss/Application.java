package com.ss;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.ss.filter.CharacterEncodingFilter;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
	public FilterRegistrationBean authFilterRegistration() {
		
		FilterRegistrationBean registration = new FilterRegistrationBean(new CharacterEncodingFilter());
		registration.addUrlPatterns("/*"); //
		registration.addInitParameter("paramName", "paramValue"); //
		registration.setName("CharacterEncodingFilter");
		registration.setOrder(1);
		return registration;
	}
}
