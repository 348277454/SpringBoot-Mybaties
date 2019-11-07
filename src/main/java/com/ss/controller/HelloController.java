package com.ss.controller;

import java.text.DateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;


@Validated
@Controller
public class HelloController {
	
	private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

	/*@Value("${name}")
	private String name;
	
	@Value("${age}")
	private String age;
	
	@Value("${content}")
	private String content;
	
	
	@Autowired
	private StudentProperties properties;*/
	
	/*ValueOperations<String, String> stringRedis;
	
	
	@Autowired
    StringRedisTemplate redisTemplate;
	
	@RequestMapping("/hello")
	public String hello(Model model,@NotNull(message="{hello.key.notNull}") String key){
		LOG.info("hello start ... ");
		stringRedis = redisTemplate.opsForValue();
		
		model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
		model.addAttribute("value", stringRedis.get(key));
		
		return "hello";
	
	}*/
}
