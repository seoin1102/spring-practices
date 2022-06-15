package com.douzone.container.config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.user.Friend;
import com.douzone.container.user.User;

@Configuration
public class AppConfig02 {
	
	// 명시적으로 bean설정
	@Bean
	public User user() {
		
		return new User();
	}
}
